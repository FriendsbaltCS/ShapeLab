import java.util.ArrayList;

public abstract class Polygon implements MeasurableShape {
    private PlaneVector[] verts;
    private PlaneVector[] sidelengths;
    private int dim;

    public Polygon(PlaneVector[] verts) {

    }

    @Override
    public double area() {

    }

    @Override 
    public double perimeter() {

    }

    @Override
    public PlaneVector center() {

    }

    public PlaneVector[] verts() {
        PlaneVector[] x = new PlaneVector[verts.length];
        System.arraycopy(verts, 0, x, 0, verts.length);
        return x;
    }

    public PlaneVector[] sideLengths() {
        PlaneVector[] x = new PlaneVector[sidelengths.length];
        System.arraycopy(sidelengths, 0, x, 0, sidelengths.length);
        return x;
    }
}
