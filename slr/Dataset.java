
package slr;

public class Dataset {

    double[] y = {651,762,856,1063,1190,1298,1421,1440,1518};
    double[] x = {23,26,30,34,43,48,52,57,58};
    int n = y.length;

    public int getN() {
        return n;
    }

    public Dataset(double[] yi, double[] xi) {//SLR case
        y = yi;
        x = xi;
    } 
    public Dataset() {
    }

    public double[] getY() {
        for(int i = 0; i < y.length; i++){
        //System.out.println(y[i]); //To confirm data
        }
        return y;
    }

    public double[] getX(){ 
        for(int i = 0; i < x.length; i++){
        //System.out.println(x[i]); //To confirm data
        }
        return x;
    }      
}
