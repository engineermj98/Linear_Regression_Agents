
package gd;

public class Dataset_Simple {
    
    public Dataset_Simple() {
    }     
    double[] x = {23,26,30,34,43,48,52,57,58}; //simple
    double[] y = {651,762,856,1063,1190,1298,1421,1440,1518};//simple
    int n = y.length;
    
    public double[] getX() {
        return x;
    }
        

    public int getN() {
        n = y.length;
        return n;
    }
    public double[] getY() {
        for(int i = 0; i < y.length; i++){
        //System.out.println(y[i]);
        }
        return y;
    }
}
