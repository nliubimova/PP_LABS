import java.util.Scanner;
import java.text.*;
public class Main {
   public static void main (String[] args){

       Scanner in = new Scanner (System.in);
       System.out.print("Input number x:");
       double x = in.nextDouble();

       System.out.print("Input degree for epsilon k:");
       int k = in.nextInt();
       double eps = Math.pow(10,-k*2);


       double exponent=1.0;
       double l=1;
       for (int i=1; Math.abs(l)>=eps; i++)
       {
           l*=(x/i);
           exponent+=l;
       }
NumberFormat formatter = NumberFormat.getNumberInstance();
       formatter.setMaximumFractionDigits(k);
       System.out.print(" My exponent is: ");
       System.out.println(formatter.format(exponent));
       System.out.print(" Java exponent is: ");
       System.out.println(formatter.format( Math.exp(x)));
   }
}