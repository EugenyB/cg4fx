package view;

import javafx.scene.canvas.GraphicsContext;
import model.*;

import java.util.stream.Collectors;

/**
 * Created by eugeny on 04.11.2015.
 */
public class MyView {
    private double f = 500;

    private double[][] m = {
            {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}
    };

    private double xs(Point3D p) {
        return p.getX() * f / p.getZ();
    }

    private double ys(Point3D p) {
        return p.getY() * f / p.getZ();
    }

    public void drawFigure(Figure f, GraphicsContext gc) {
        int n = f.getFacesCount();
        for (int i = 0; i < f.getFacesCount(); i++) {
            Polygon3D face = f.getFace(i);
            drawPolygon(face, gc);
        }
    }

    private void drawPolygon(Polygon3D polygon3D, GraphicsContext gc) {
        Polygon2D polygon2D = makeProjection(polygon3D);
        gc.strokePolygon(polygon2D.getXs(), polygon2D.getYs(), polygon2D.size());
    }

    private Polygon2D makeProjection(Polygon3D polygon3D) {
        return new Polygon2D(
                polygon3D
                        .getPoints()
                        .stream()
                        .map(this::transform)
                        .map(this::projection)
                        .collect(Collectors.toList())
        );
    }

    private Point2D projection(Point3D p) {
        return new Point2D(xs(p), ys(p));
    }

    private Point3D transform(Point3D p) {
        double x = m[0][0] * p.getX() + m[0][1] * p.getY() + m[0][2] * p.getZ() + m[0][3];
        double y = m[1][0] * p.getX() + m[1][1] * p.getY() + m[1][2] * p.getZ() + m[1][3];
        double z = m[2][0] * p.getX() + m[2][1] * p.getY() + m[2][2] * p.getZ() + m[2][3];
        return new Point3D(x, y, z);
    }
}
