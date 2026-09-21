/**
 * This interface represents the basic functionality of a geometric shape in
 * the 2D Euclidean plan that can be measured using the simple quantities of
 * area, perimeter, and center. The category of "shape" applies to any simple
 * (i.e. non-self-intersecting) region of space enclosed by a curve or curves.
 * 
 * The quantities should be thought of analgously in cases where geometric
 * terminology differs. In the case of a circle, the perimeter function
 * should be implemented to give the circumference.
 */
public interface MeasurableShape {
    
    /**
     * Measures the area enclosed by the object's boundary curve(s).
     * @return The area of the object.
     */
    public double area();

    /**
     * Returns the length of the shape's boundary curve or (if there are mulitple)
     * the sum of the lengths of all boundary curves.
     * @return The total length of the object's boundary.
     */
    public double perimeter();

    /**
     * Returns the coordinate of the geometric center or "centroid" of the shape.
     * @return the object's geometric center.
     */
    public PlaneVector center();
    
}