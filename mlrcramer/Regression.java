
package mlrcramer;

public interface Regression {
    public double b0(double DS, double DB0);
    public double b1(double DS, double DB1);
    public double b2(double DS, double DB2);
    public double predictiveEcuation(double B0, double B1, double B2, double x1, double x2);
}
