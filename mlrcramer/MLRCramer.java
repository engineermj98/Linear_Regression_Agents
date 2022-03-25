
package mlrcramer;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.util.Scanner;
public class MLRCramer extends Agent implements Regression{    

    Maths maths = new Maths();
    Cramer cramer = new Cramer();
    Dataset ds = new Dataset();
    Scanner sc = new Scanner(System.in);
    
    @Override
    public double b0(double DS, double DB0) {
        double B0 = DB0/DS;     
        System.out.println("B0 by Cramer: "+B0);
        return B0;    }

    @Override
    public double b1(double DS, double DB1) {
        double B1 = DB1/DS;   
        System.out.println("B1 by Cramer: "+B1);
        return B1;    }

    @Override
    public double b2(double DS, double DB2) {
        double B2 = DB2/DS;
        System.out.println("B2 by Cramer: "+B2);
        return B2;    }
    
    @Override
    public double predictiveEcuation(double B0, double B1, double B2, double x1, double x2) {
        double PR;
        PR = B0+B1*x1+B2*x2;
        System.out.println("x1: "+x1+", x2: "+x2+", then y = "+PR);
        return PR;    }
    
    public void setup(){
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MultipleLinearRegression());
    }

    
    private class MultipleLinearRegression extends Behaviour{
        int cont = 0;

        @Override
        public void action() {
            double x1,x2;
            cramer.systemDeterminant(ds.getN(), maths.sigma(maths.sqr(ds.getX1())), maths.sigma(maths.sqr(ds.getX2())), maths.sigma(ds.getX1()), maths.sigma(maths.product(ds.getX1(), ds.getX2())), maths.sigma(ds.getX2()));
            cramer.b0Determinant(ds.getN(), maths.sigma(maths.sqr(ds.getX1())), maths.sigma(maths.sqr(ds.getX2())), maths.sigma(ds.getX1()), maths.sigma(maths.product(ds.getX1(), ds.getX2())), maths.sigma(ds.getX2()), maths.sigma(ds.getY()), maths.sigma(maths.product(ds.getX1(),ds.getY())), maths.sigma(maths.product(ds.getX2(), ds.getY())));
            cramer.b1Determinant(ds.getN(), maths.sigma(maths.sqr(ds.getX1())), maths.sigma(maths.sqr(ds.getX2())), maths.sigma(ds.getX1()), maths.sigma(maths.product(ds.getX1(), ds.getX2())), maths.sigma(ds.getX2()), maths.sigma(ds.getY()), maths.sigma(maths.product(ds.getX1(),ds.getY())), maths.sigma(maths.product(ds.getX2(), ds.getY())));
            cramer.b2Determinant(ds.getN(), maths.sigma(maths.sqr(ds.getX1())), maths.sigma(maths.sqr(ds.getX2())), maths.sigma(ds.getX1()), maths.sigma(maths.product(ds.getX1(), ds.getX2())), maths.sigma(ds.getX2()), maths.sigma(ds.getY()), maths.sigma(maths.product(ds.getX1(),ds.getY())), maths.sigma(maths.product(ds.getX2(), ds.getY()))); 
            x1 = sc.nextDouble();
            x2 = sc.nextDouble();
            predictiveEcuation(b0(cramer.getDS(),cramer.getDB0()), b1(cramer.getDS(),cramer.getDB1()), b2(cramer.getDS(),cramer.getDB2()), x1, x2);
            cont+=1;         
        }

        @Override
        public boolean done() {
            if(cont == 1){
                return true;
            }else{
                return false;
            }
        }
        @Override
        public int onEnd() {
            //myAgent.doDelete();
            return super.onEnd();
        }
    }
    
}
