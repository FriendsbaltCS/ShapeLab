import java.util.Objects;
/**
 * The PlaneVector represents a simple vector in 2D space. There are two
 * common defitions for vectors: "a quantity with magnitude and direction"
 * and "an ordered pair of n values." The first definition is commonly
 * expressed mathematically in (r, theta) format and is known as "polar
 * form." Conversely, the ordered pair definition is commonly represented
 * <x, y> and is usually thought of as the "cartesian form."
 * 
 * Ultimately, these definitions are convertible, thus, the {@code PlaneVector}
 * class is agnostic. Functionality for retrieving and manipulating both
 * types of components are available. Nevertheless, the class is immutable
 * and each mathematical operation always produces a new {@code PlaneVector}
 * object.
 */
public final class PlaneVector {
    private final Pair<Double, Double> components;

    private PlaneVector(double x, double y) {
        this.components = new Pair<>(x, y);
    }

    /**
     * Constructs a new {@code PlaneVector} from <x, y> components
     * @param x the x- (horizontal) component of the new vector
     * @param y the y- (vertical) component of the new vector
     * @return a plane vecotr equivalen to <x, y>
     */
    public static PlaneVector fromXY(Double x, Double y) {
        return new PlaneVector(x, y);
    }

    /**
     * Constructs a new {@code PlaneVector} from (r, theta) components
     * @param r the magnitude of the vector
     * @param theta the direction of the vector measured from the positive x-axis
     * @return
     */
    public static PlaneVector fromPolar(Double r, Double theta) {

    }

    /**
     * Retrieves the scalar x-component of the vector
     * @return this vector's x-component
     */
    public double x() {

    }

    /**
     * Retrieves the scalar y-component of the vector
     * @return this vector's y (vertical) component.
     */
    public double y() {

    }

    /**
     * Retries the "r" value of the vector in (r, theta) form
     * @return the length of the vector from the origin
     */
    public double r() {
        return this.norm();
    }
    
    /**
     * Computes the standard angle of the vector measured counter-clockwise from the
     * positive x-axis.
     * @return The theta value of the vector in radians.
     */
    public double theta() {

    }

    /**
     * Computes the sum of two vectors.
     * @param that the vector to add to this.
     * @return this + that
     */
    public PlaneVector plus(PlaneVector that) {

    }

    /**
     * Computes the difference of two vectors.
     * @param that the second vector in the difference.
     * @return this - that
     */
    public PlaneVector minus(PlaneVector that) {

    }

    /**
     * Computes the dot product of this and another vector
     * @param that the second vector in the dot product
     * @return this . that
     */
    public double dot(PlaneVector that) {

    }

    /**
     * Computes a new vector in the same direction as this with its
     * magnitude adjusted by a scale factor.
     * 
     * @param scl - the scale factor to multiply this by
     * @return - a new vector equal to scl * this.
     */
    public PlaneVector scl(double scl) {

    }

    /**
     * @return The square of the magnitude of this vector.
     */
    public double normSquared() {

    }

    /**
     * @return The magnitude or "length" of this vector.
     */
    public double norm() {

    }

    /**
     * Computes a vector of length 1 in the same direction as this.
     * @return a new unit vector corresponding to this.
     */
    public PlaneVector unitVector() {

    }

    /**
     * Returns a vector with the same x component and 0 y component as this vector.
     * @return a vector of just the x component of this
     */
    public PlaneVector xComponentVector() {

    }

    /**
     * Returns a vector with the same y component and 0 x component as this vector.
     * @return a vector of just the y component of this
     */
    public PlaneVector yComponentVector() {

    }

    /**
     * Computes the magnitued of the 3D cross product this x that. This is equivalent
     * to the area of the parallelogram formed by the two vectors.
     * @param that
     * @return
     */
    public double cross(PlaneVector that) {

    }

    /**
     * Returns a new vector equal to (r, theta + alpha)
     * @param alpha the angle of rotation in radians
     * @return this rotated by alpha radians
     */
    public PlaneVector rotate(double alpha) {

    } 

    /* Two vectors are equal if they have the same component valus */
    @Override
    public boolean equals(Object o) {

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x(), this.y());
    }

    @Override
    public String toString() {
        return "<" + this.x() + ", " + this.y() + ">";
    }
}
