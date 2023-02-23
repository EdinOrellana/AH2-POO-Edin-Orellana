
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author edin1
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NewMain clase = new NewMain();
        do {
            System.out.println("1.Debitar \n2.Acreditar");
            int n1 = sc.nextInt();
            System.out.println("1.Cuenta No.1 \n2.Cuenta No.2");
            int n2 = sc.nextInt();
            switch (n1) {
                case 1:
                    System.out.print("Ingresa el monto a debitar: ");
                    clase.debitar(sc.nextInt(), n2);
                    break;
                case 2:
                    System.out.print("Ingresa el monto a acreditar: ");
                    clase.acreditar(sc.nextInt(), n2);
                    break;
            }
        } while (true);

    }
    int cuenta1 = 0, cuenta2 = 0;

    public void debitar(int n1, int cuenta) {
        switch (cuenta) {
            case 1:
                cuenta1 += n1;
                System.out.println("Tienes un total de: " + cuenta1);
                break;
            case 2:
                cuenta2 += n1;
                System.out.println("Tienes un total de: " + cuenta2);
                break;
        }
    }

    public void acreditar(int n1, int cuenta) {
        switch (cuenta) {
            case 1:
                cuenta1 -= n1;
                System.out.println("Tienes un total de: " + cuenta1);
                break;
            case 2:
                cuenta2 -= n1;
                System.out.println("Tienes un total de: " + cuenta2);
                break;
        }

    }
}
