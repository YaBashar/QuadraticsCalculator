import java.util.ArrayList;
import java.util.Scanner;
public class QuadraticExtract {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the Quadratic Equation Calculator");
        System.out.println("Enter your quadratic in the form ax^2+bx+c=z");
        System.out.println("z doesn't have to be 0 it can be any number");

        Scanner keyboard = new Scanner(System.in);
        double a = Double.parseDouble(keyboard.findInLine("-?([0-9]+)"));
        double b = Double.parseDouble(keyboard.findInLine("[-+]!?[0-9]\\d*"));
        double c = Double.parseDouble(keyboard.findInLine("[-+]!?[0-9]\\d*"));
        String equalsign = keyboard.findInLine("=");
        double z = Double.parseDouble(keyboard.findInLine("-?([0-9]+)"));

        if (z !=0){
            c -= z;
            z-=z;
        }

        String text = "";
        if (a > 1) {
            text += Math.round(a);
        }
        text+= "x\u00B2";
        if (b > 0) {
            text += "+";
        }
        text += Math.round(b);
        text += "x";

        if (c > 0) {
            text += "+";
        }
        text += Math.round(c);
        text += equalsign;
        text += Math.round(z);
        System.out.println(text);

        System.out.println("a = " + Math.round(a));
        System.out.println("b = " + Math.round(b));
        System.out.println("c = " + Math.round(c));

        System.out.println(calculating(a,b,c));
    }

    public static ArrayList<Double> calculating(double a, double b, double c) {
        ArrayList<Double>roots = new ArrayList<>();
        double discriminant = b*b - 4 * a * c;
        double sqrtofdiscriminant = Math.sqrt(discriminant);
        double minusb = - b;

        switch((int)Math.signum(discriminant)){
            case -1:
            break;

            case 0:
                roots.add((minusb + sqrtofdiscriminant)/(2*a));
            break;

            case 1:
                roots.add((minusb + sqrtofdiscriminant)/(2*a));
                roots.add((minusb - sqrtofdiscriminant)/(2*a));
            break;
        }
        return roots;
    }
}
