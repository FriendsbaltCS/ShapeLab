/**
 * Represents an ordered pair of objects. This class is immutable with
 * respect to its own structure. That is, the pointers assigned to each
 * component cannot be changed. If the underlying objects within the pair
 * are themselves immutable, then a Pair object is fully immutable, otherwise
 * the immutability is only shallow as these objects can be changed.
 * 
 * @param <S> Type of the first component of the ordered pair.
 * @param <T> Type of the second component of the ordered pair.
 */
public final class Pair<S, T> {
    private final S first;
    private final T second;

    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @return The first component of the pair.
     */
    public S first() {
        return this.first;
    }

    /**
     * @return The second component of the pair.
     */
    public T second() {
        return this.second;
    }

    /**
     * Returns a new pair equivalent to the transpose of this pair.
     * Transpose here simply means "swapped," so the transpose of
     * pair (x, y) will by (y, x).
     * @return A new pair with the coordinates of this pair swapped.
     */
    public Pair<T, S> transpose() {
        return new Pair<>(second, first);
    }
}
