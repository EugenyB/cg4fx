package model;

import view.MyView;

/**
 * Created by eugeny on 04.11.2015.
 */
public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Point3D transform(double[][] m) {
        double x = m[0][0] * getX() + m[0][1] * getY() + m[0][2] * getZ() + m[0][3];
        double y = m[1][0] * getX() + m[1][1] * getY() + m[1][2] * getZ() + m[1][3];
        double z = m[2][0] * getX() + m[2][1] * getY() + m[2][2] * getZ() + m[2][3];
        return new Point3D(x, y, z);
    }
}
