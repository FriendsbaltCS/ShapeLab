public class Triangle extends SimplePolygon {

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {

    }

    public boolean isRight() {
        PlaneVector[] sides = sidelengths();

        for (int i = 0; i < sides.length; i++) {
            int j = (i + 1) % sides.length;
            PlaneVector u = sides[i];
            PlaneVector v = sides[j];

            if (u.dot(v) == 0) return true;
        }

        return false;
    }
}
