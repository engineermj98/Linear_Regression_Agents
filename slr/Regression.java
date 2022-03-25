
package slr;

public interface Regression {
    public double b0(double YiZigma, double XiZigma, double B1, int n);
    public double b1(double xiYiZigma, double xiZigma, double YiZigma, double xSqrZigma,int n);
    public double predictiveEc(double B0, double B1, double x);
}
