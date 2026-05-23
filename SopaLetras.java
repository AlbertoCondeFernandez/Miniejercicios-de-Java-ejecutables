import java.util.Scanner;
import java.util.Arrays;
public class SopaLetras {
    /*
    Programa que simula una sopa de letras en un tablero 8x8
    Se sale del programa cuando se escribe un numero vertical negativo
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        //constantes tamaño tablero no alterable
        final int ANCHO = 8;
        final int ALTO = 8;
        char[][] sopa = new char[ANCHO][ALTO];
        //variable gaurdada para caracter
        char resp;
        //variables coordenadas
        int x, y;

        //rellenado de la sopa con el carácter '.'
        for (int i = 0; i < sopa.length; i++) {
            Arrays.fill(sopa[i], '.');
        }

        //Inicio del bucle
        do{
            System.out.println("Dime la posición vertical");
            y = in.nextInt();
            if(y>=0) {
                while (y >= ANCHO) {
                    System.out.println("Posición incorrecta, vuelve a intentarlo");
                    System.out.println("Dime la posición vertical");
                    y = in.nextInt();
                }
                System.out.println("Dime la posición horizontal");
                x = in.nextInt();
                while (x < 0 || x >= ALTO) {
                    System.out.println("Posición incorrecta, vuelve a intentarlo");
                    System.out.println("Dime la posición horizontal");
                    x = in.nextInt();
                }
                in.nextLine();
                System.out.println("Escribe el carácter que quieres poner en el tablero");
                resp = in.nextLine().charAt(0);
                sopa[y][x] = resp;
                //mostrar tablero
                for (int i = 0; i < sopa.length; i++) {
                    for (int j = 0; j < sopa[i].length; j++) {
                        System.out.print(sopa[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }while(y>=0);

        System.out.println("¡Hasta pronto!");

    }
}

//Alberto Conde Fernández