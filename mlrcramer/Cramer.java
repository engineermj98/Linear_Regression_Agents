/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlrcramer;

/**
 *
 * @author Tonajul
 */
public class Cramer {
    double DS = 0, DB0 = 0, DB1 = 0, DB2 = 0, B0 = 0, B1 = 0, B2 = 0;

    public double getDS() {
        return DS;
    }

    public void setDS(double DS) {
        this.DS = DS;
    }

    public double getDB0() {
        return DB0;
    }

    public void setDB0(double DB0) {
        this.DB0 = DB0;
    }

    public double getDB1() {
        return DB1;
    }

    public void setDB1(double DB1) {
        this.DB1 = DB1;
    }

    public double getDB2() {
        return DB2;
    }

    public void setDB2(double DB2) {
        this.DB2 = DB2;
    }
    public double systemDeterminant(int n, double sigmax1sqr, double sigmax2sqr,double sigmax1, double sigmax1x2, double sigmax2){   
        DS = n*sigmax1sqr*sigmax2sqr+sigmax1*sigmax1x2*sigmax2+sigmax2*sigmax1*sigmax1x2-sigmax2*sigmax1sqr*sigmax2-n*sigmax1x2*sigmax1x2-sigmax2sqr*sigmax1*sigmax1;
        //System.out.println("DS: "+DS);
        setDS(DS);
        return DS;
    }
    public double b0Determinant(int n, double sigmax1sqr, double sigmax2sqr,double sigmax1, double sigmax1x2, double sigmax2, double sigmayi, double sigmax1yi, double sigmax2yi){
        DB0 = sigmayi*sigmax1sqr*sigmax2sqr+sigmax1*sigmax1x2*sigmax2yi+sigmax2*sigmax1yi*sigmax1x2-sigmax2yi*sigmax1sqr*sigmax2-sigmax1x2*sigmax1x2*sigmayi-sigmax2sqr*sigmax1yi*sigmax1;
        //System.out.println("DB0: "+DB0);
        setDB0(DB0);
        return DB0;
    }
    public double b1Determinant(int n, double sigmax1sqr, double sigmax2sqr,double sigmax1, double sigmax1x2, double sigmax2, double sigmayi, double sigmax1yi, double sigmax2yi){
        DB1 = n*sigmax1yi*sigmax2sqr+sigmayi*sigmax1x2*sigmax2+sigmax2*sigmax1*sigmax2yi-sigmax2*sigmax1yi*sigmax2-sigmax2yi*sigmax1x2*n-sigmax2sqr*sigmax1*sigmayi;
        //System.out.println("DB1: "+DB1);   
        setDB1(DB1);
        return DB1;
    }
    public double b2Determinant(int n, double sigmax1sqr, double sigmax2sqr,double sigmax1, double sigmax1x2, double sigmax2, double sigmayi, double sigmax1yi, double sigmax2yi){
        DB2 = n*sigmax1sqr*sigmax2yi+sigmax1*sigmax1yi*sigmax2+sigmayi*sigmax1*sigmax1x2-sigmax2*sigmax1sqr*sigmayi-sigmax1x2*sigmax1yi*n-sigmax2yi*sigmax1*sigmax1;
        //System.out.println("DB2: "+DB2); 
        setDB2(DB2);
        return DB2;
    }
}
