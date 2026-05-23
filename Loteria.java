import java.util.Scanner;
public class Loteria {
    /*
    Programa que simula un sorteo de lotería.
    Genera números aleatorios del 0 al 99 y reparte premios.
    El usuario puede repetir el sorteo tantas veces como quiera.
   */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] esfera = new int[100];
        String resp;

        //rellenado la esfera
        for (int i = 0; i < esfera.length; i++) {
            esfera[i] = i;
        }

        do {
            //barajado la esfera
            for (int i = 0; i < esfera.length; i++) {
                int pos = (int) (Math.random() * 100);
                int aux = esfera[i];
                esfera[i] = esfera[pos];
                esfera[pos] = aux;
            }

            //mostrar premios
            System.out.println("Premios:");
            System.out.println("1º premio: " + esfera[0]);
            System.out.println("2º premio: " + esfera[1]);
            System.out.println("3º premio: " + esfera[2]);
            System.out.println("Cuartos premios: " + esfera[3] + " " + esfera[4] + " " + esfera[5]);
            System.out.println("Pedrea: ");
            for (int i = 6; i < 16; i++) {
                System.out.print(esfera[i] + " ");
            }
            System.out.println("\n\n");
            System.out.println("¿Quieres volver a generar un sorteo? (sí/no)");
            resp = in.nextLine().toUpperCase();
            while(!(resp.equals("SÍ") || resp.equals("SI") || resp.equals("NO"))){
                System.out.println("Respuesta incorrecta, vuelve a intentarlo");
                System.out.println("¿Quieres volver a generar un sorteo? (sí/no)");
                resp = in.nextLine().toUpperCase();
            }
        }while(resp.equals("SÍ") || resp.equals("SI"));

        System.out.println("¡Hasta pronto!");

    }
}
//Alberto Conde Fernández