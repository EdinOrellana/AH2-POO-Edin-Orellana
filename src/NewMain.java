
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
        int no1 = 0;
        do {
            System.out.println("=====MENU PRINCIPAL=====");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("4. Salir");
            System.out.print("Elije tu opcion: ");
            no1 = sc.nextInt();
            switch (no1) {
                case 1:
                    System.out.println("entro");
                    for (int i = 0; i < 64; i++) {
                        Numero[1][i] = " ";
                        Numero[2][i] = " ";
                    }
                    for (int i = 1; i < 65; i++) {
                        if (!(i / 10 == 0)) {
                            Numero[0][i - 1] = Integer.toString(i);
                        } else {
                            Numero[0][i - 1] = " " + Integer.toString(i);
                        }
                        // System.out.println(Integer.toString(i + 1));
                        if ((i + 1) % 8 == 0) {
                            int minimo = i - 6;
                            int cantidad = (int) (Math.floor(Math.random() * (3 - 1 + 1)) + 1);
                            for (int j = 0; j < cantidad; j++) {
                                int a = 0;
                                a = (int) (Math.floor(Math.random() * ((i) - minimo + 1)) + minimo);
                                while ("#".equals(Numero[1][a])) {
                                    //System.out.println("repite " + a);
                                    a = (int) (Math.floor(Math.random() * ((i) - minimo + 1)) + minimo);
                                }
                                Numero[1][a] = "#";
                                //System.out.println("entra" + a);

                            }
                        }
                    }
                    Numero[2][0] = "@";
                    Bucle();
                    break;

                case 2:
                    if (!(Numero[0][0] == null)) {
                        Bucle();
                    }
                    break;
            }
        } while (true);
    }
    static String[][] Numero = new String[3][64];
    static Scanner sc = new Scanner(System.in);
    static int jugador = 0, dado = 0, posicion = 64;

    static void repeticion1() {
        System.out.println("entro 1");
        for (int i = 8; i > 0; i--) {
            System.out.print("| " + Numero[0][posicion - i] + "|");
        }
        System.out.println("");
        for (int i = 8; i > 0; i--) {
            System.out.print("| " + Numero[2][posicion - i] + Numero[1][posicion - i] + "|");
        }
        System.out.println("");
        System.out.println("----------------------------------------");
        posicion -= 9;
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + Numero[0][posicion - i] + "|");
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + Numero[2][posicion - i] + Numero[1][posicion - i] + "|");
        }
        System.out.println("");
        System.out.println("----------------------------------------");

    }

    static void repeticion2() {
        posicion -= 15;
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + Numero[0][posicion + i] + "|");
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + Numero[2][posicion + i] + Numero[1][posicion + i] + "|");
        }
        System.out.println("");
        System.out.println("----------------------------------------");
        posicion -= 1;
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + Numero[0][posicion - i] + "|");
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print("| " + Numero[2][posicion - i] + Numero[1][posicion - i] + "|");
        }
        System.out.println("");
        System.out.println("----------------------------------------");
    }

    static void Bucle() {
        int seleccion;

        do {
            posicion = 64;
            repeticion1();
            for (int i = 0; i < 3; i++) {
                repeticion2();
            }

            if (jugador >= 63) {
                System.out.println("HAS GANADO");
                dado = 0;
                jugador = 0;
                return;
            } else if ("#".equals(Numero[1][jugador])) {
                System.out.println("El dado callo en " + dado);
                System.out.println("!Has caido en una pennalizacion¡");
            } else if (dado != 0) {
                System.out.println("El dado callo en " + dado);
            } else {
                System.out.println("Has iniciado en la casilla 1");
            }
            System.out.println("1. Tirar dado 2.Volver al menu");
            seleccion = sc.nextInt();
            if (seleccion == 1) {
                dado = (int) (Math.floor(Math.random() * (6 - 2 + 1)) + 2);
                if (jugador + dado > 63) {
                    Numero[2][jugador] = " ";
                    Numero[2][jugador = 63] = "@";

                } else {
                    Numero[2][jugador += dado] = "@";
                    Numero[2][jugador - dado] = " ";
                }
            }
        } while (seleccion == 1);
    }
}
