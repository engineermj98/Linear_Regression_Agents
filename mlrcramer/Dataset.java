
package mlrcramer;

public class Dataset {

    public double y[] = {251.3,251.3,248.3,267.5,273.0,276.5,270.3,274.9,285.0,290.0,297.0,302.5,304.5,309.3,321.7,330.7,349.0};
    public double x1[] = {41.9,43.4,43.9,44.5,47.3,47.5,47.9,50.2,52.8,53.2,56.7,57.0,63.5,65.3,71.1,77.0,77.8};
    public double x2[] = {29.1,29.3,29.5,29.7,29.9,30.3,30.5,30.7,30.8,30.9,31.5,31.7,31.9,32.0,32.1,32.5,32.9};
    int n = y.length;

    public int getN() {
        n = y.length;
        return n;
    }

    public Dataset(double[] yi, double[] x1i, double[] x2i) {//MLR case
        y = yi;
        x1 = x1i;
        x2 = x2i;
    } 
    public Dataset() {
    }

    public double[] getX1() {
        return x1;
    }

    public double[] getX2() {
        return x2;
    }

    public double[] getY() {
        for(int i = 0; i < y.length; i++){
        //System.out.println(y[i]);
        }
        return y;
    }
}
