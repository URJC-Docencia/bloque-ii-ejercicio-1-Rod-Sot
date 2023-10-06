
import material.Position;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

    public abstract class DrawableTree<E> implements NAryTree<E> {

        /**
         * Generate a DOT representation of the tree.
         * <p>
         * The DOT format is a plain text graph description language used to
         * represent various types of graphs.
         * <p>
         * To visualize dot files you can sumply use: <a href="https://dreampuf.github.io/GraphvizOnline/">Graphviz Online</a>
         *
         * @return a string representing the tree in the DOT format
         */
        public String toDot() {
            StringBuilder sb = new StringBuilder("digraph Tree {\n");
            if (!isEmpty()) {
                toDot(root(), sb);
            }
            sb.append("}");
            return sb.toString();
        }


        /**
         * Recursively generate the DOT representation of the tree starting from the given node.
         *
         * @param node the starting node
         * @param sb   the StringBuilder to append the DOT representation to
         */
        private void toDot(Position<E> node, StringBuilder sb) {
            for (Position<E> child : children(node)) {
                sb.append("\"").append(node.getElement()).append("\" -> \"").append(child.getElement()).append("\";\n");
                toDot(child, sb);
            }
        }

        /**
         * Save the DOT representation of the tree to a file.
         *
         * @param fileName the name of the file to save the DOT representation to
         * @throws IOException if there is an error writing to the file
         * @ return a string with the absolute path of the file
         */
        public String saveDotToFile(String fileName) throws IOException {
            String filePath = System.getProperty("user.dir") + "/" + fileName;
            Files.write(Paths.get(filePath), toDot().getBytes());
            return filePath;
        }

        /**
         * Generate an image using the dot generate by the saveDotToFile method.
         */

        public void generateImage() {
            var timestamp = System.currentTimeMillis();
            generateImage("tree" + timestamp);
        }


        /**
         * Generate an image using the dot generate by the saveDotToFile method.
         */

        public void generateImage(String name) {
            try {
                String filePath = "\"" + saveDotToFile(name + ".dot");
                String[] cmd = {"dot", "-Tpng", filePath + "\"", "-o", filePath + ".png\""};
                Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
