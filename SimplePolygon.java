import java.util.Arrays;

/**
 * A SimplePolygon is a polygon which does not allow for self-intersection.
 * Internally, {@code SimplePolygon} objects always have their vertices
 * sorted in counter-clockwise order from their center.
 */
public class SimplePolygon extends Polygon {

	/**
	 * Constructs a simple polygon from vertices supplied in any order.
	 *
	 * @param verts the vertices of the polygon
	 */
	public SimplePolygon(PlaneVector[] verts) {
		super(sortCounterClockwise(verts));
	}

	private static PlaneVector[] sortCounterClockwise(PlaneVector[] verts) {
		PlaneVector[] sortedVerts = Arrays.copyOf(verts, verts.length);
		double centerX = 0.0;
		double centerY = 0.0;

		for (PlaneVector vert : sortedVerts) {
			centerX += vert.x();
			centerY += vert.y();
		}

		final double averageX = centerX / sortedVerts.length;
		final double averageY = centerY / sortedVerts.length;

		Arrays.sort(sortedVerts, (first, second) -> Double.compare(
				Math.atan2(first.y() - averageY, first.x() - averageX),
				Math.atan2(second.y() - averageY, second.x() - averageX)));

		return sortedVerts;
	}
}
