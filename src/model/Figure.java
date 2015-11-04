package model;

/**
 * Created by eugeny on 04.11.2015.
 */
public class Figure {
    private double[] x = {200, 400, 400, 200, 200, 400, 400, 200};
    private double[] y = {400, 400, 200, 200, 400, 400, 200, 200};
    private double[] z = {600, 600, 600, 600, 800, 800, 800, 800};

    private int[][] p = {
            {0,1,2,3},
            {1,5,6,2},
            {3,2,6,7},
            {0,4,5,1},
            {0,3,7,4},
            {4,7,6,5}
    };

    public int getFacesCount() {
        return p.length;
    }

    public Polygon3D getFace(int i) {
        if (i<0 || i>=p.length) {
            throw new IndexOutOfBoundsException("face num must be in[0..."+(p.length-1)+"], but was:" + i);
        }
        Point3D[] p3d = new Point3D[p[i].length];
        for (int j = 0; j < p[i].length; j++) {
            p3d[j] = new Point3D(x[p[i][j]], y[p[i][j]], z[p[i][j]]);
        }
        return new Polygon3D(p3d);
    }
}
