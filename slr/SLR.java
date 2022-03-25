
package slr;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.util.Scanner;



public class SLR extends Agent implements Regression{
    Maths math = new Maths();
    Dataset ds = new Dataset();
    Scanner sc = new Scanner(System.in);
    public void setup(){
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new SimpleLinearRegression());

    }

    @Override
    public double b0(double YiZigma, double XiZigma, double B1, int n) {
        double B0 = 0;
        B0 = (YiZigma - B1*XiZigma)/n;
        System.out.println("B0: "+B0);
        return B0;
    }

    @Override
    public double b1(double xiYiZigma, double xiZigma, double YiZigma, double xSqrZigma, int n) {
        double B1 = 0;
        B1 = (n*xiYiZigma-xiZigma*YiZigma)/(n*xSqrZigma-xiZigma*xiZigma);
        System.out.println("B1: "+B1);
        return B1;    }

    @Override
    public double predictiveEc(double b0, double b1, double x) {
        double PR;
        PR = b0+b1*x;
        System.out.println("x: "+x+", then y = "+PR);
        return PR;

    }

    private class SimpleLinearRegression extends Behaviour{
        int cont = 0;

        @Override
        public void action() {
            double B0, B1, value;           
            B1 = b1(math.sigma(math.product(ds.getX(), ds.getY())),math.sigma(ds.getX()),math.sigma(ds.getY()),math.sigma(math.sqr(ds.getX())),ds.getN());
            B0 = b0(math.sigma(ds.getY()),math.sigma(ds.getX()),B1,ds.getN());
            value = sc.nextDouble();
            predictiveEc(B0, B1, value);
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
