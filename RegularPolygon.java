public class RegularPolygon extends Polygon {

    public RegularPolygon(double x, double y, int n) {
        if (n < 3) {
            throw new IllegalArgumentException("Polygons must have > 2 vertices");
        }

        
    }
}