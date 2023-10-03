package material;

/**
 * Represents a position in a data structure that stores an element of type E.
 *
 * @param <E> the type of the element stored in this position
 */
public interface Position<E> {
    /**
     * Return the element stored at this position.
     *
     * @return the stored element
     */
    E getElement();
}
