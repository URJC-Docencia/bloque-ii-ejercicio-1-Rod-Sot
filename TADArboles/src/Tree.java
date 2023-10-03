import material.Position;


/**
 * This interface represents a Tree data structure, which is a collection of nodes organized in a hierarchical structure.
 * The Tree interface provides methods to access and manipulate the nodes of the tree.
 *
 * @param <E> the type of elements stored in the tree.
 */
public interface Tree<E> extends Iterable<Position<E>> {

    /**
     * Returns whether the tree is empty.
     *
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns the root of the tree.
     *
     * @return the root of the tree.
     */
    public Position<E> root();

    /**
     * Returns the parent of a given node.
     *
     * @param v the node whose parent is to be returned.
     * @return the parent of the given node.
     */
    public Position<E> parent(Position<E> v);

    /**
     * Returns an iterable collection of the children of a given node.
     *
     * @param v the node whose children are to be returned.
     * @return iterable collection of the children of the given node.
     */
    public Iterable<? extends Position<E>> children(Position<E> v);

    /**
     * Returns whether a given node is internal.
     *
     * @param v the node to be tested.
     * @return true if the node is internal, false otherwise.
     */
    public boolean isInternal(Position<E> v);

    /**
     * Returns whether a given node is external.
     *
     * @param v the node to be tested.
     * @return true if the node is external, false otherwise.
     */
    public boolean isLeaf(Position<E> v);

    /**
     * Returns whether a given node is the root of the tree.
     *
     * @param v the node to be tested.
     * @return true if the node is the root of the tree, false otherwise.
     */
    public boolean isRoot(Position<E> v);
}