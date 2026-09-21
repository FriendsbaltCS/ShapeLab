public class RegularPolygon extends Polygon {

    /**
     * Constructs a regular polygon of order n from a center point and a
     * vertex.
     * @param cx the x-coordinate of the center
     * @param cy the y-coordinate of the center
     * @param vx the x-coordinate of one vertex
     * @param vy the y-coordinate of that same vertex
     */
    public RegularPolygon(double cx, double cy, double vx, double vy, int n) {
        if (n < 3) {
            throw new IllegalArgumentException("Polygons must have > 2 vertices");
        }

        
    }
}