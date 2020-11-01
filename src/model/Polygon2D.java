package model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eugeny on 04.11.2015.
 */
public class Polygon2D {
    private final List<Point2D> points;

    public Polygon2D(List<Point2D> points) {
        this.points = points;
    }

    public Polygon2D(Point2D... points) {
        this(Arrays.asList(points));
    }

    public List<Point2D> getPoints() {
        return points;
    }

    public double[] getXs() {
        return points.stream().mapToDouble(Point2D::getX).toArray();
    }

    public double[] getYs() {
        return points.stream().mapToDouble(Point2D::getY).toArray();
    }

    public int size() {
        return points.size();
    }
}
