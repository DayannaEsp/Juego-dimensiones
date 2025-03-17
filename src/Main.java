import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vida = 15;
        int experiencia = 0;
        boolean envenenado = false;

        System.out.println("Bienvenido a la Dimensión Mágica");
        System.out.println("Debes lanzar el dado y sobrevivir hasta alcanzar 50 puntos de experiencia.");

        while (vida > 0 && experiencia < 50) {
            System.out.println(" Tu vida: " + vida + " | Tu experiencia: " + experiencia);
            System.out.print("Presiona ENTER para lanzar el dado");
            scanner.nextLine();

            int dado = random.nextInt(12) + 1;
            System.out.println("Sacaste un " + dado);

            if (dado == 1 || dado == 2) {
                vida += 1;
                System.out.println("Encuentras una fuente de vida +1 vida.");
            } else if (dado >= 3 && dado <= 5) {
                vida -= 5;
                System.out.println("Eres atacado brutalmente -5 vida.");
            } else if (dado == 6 || dado == 7) {
                experiencia += 3;
                System.out.println("Ganas experiencia en la aventura +3 experiencia.");
            } else if (dado == 8 || dado == 9) {
                experiencia -= 6;
                if (experiencia < 0) experiencia = 0;
                System.out.println("Cometes un error grave -6 experiencia.");
            } else if (dado == 10 || dado == 11) {
                vida -= 8;
                System.out.println("Caes en una trampa letal -8 vida.");
            } else if (dado == 12) {
                System.out.println("Evento especial!");
                int eventoEspecial = random.nextInt(3);
                if (eventoEspecial == 0) {
                    experiencia += 10;
                    System.out.println("Encuentras un pergamino antiguo. +10 experiencia.");
                } else if (eventoEspecial == 1) {
                    envenenado = true;
                    System.out.println("Te has infectado con veneno Pierdes -2 vida por turno.");
                } else {
                    vida /= 2;
                    System.out.println("Un demonio te ataca Tu vida se reduce a la mitad.");
                }
            }

            if (envenenado) {
                vida -= 2;
                System.out.println("El veneno te debilita. -2 vida.");
            }
        }

        if (vida <= 0) {
            System.out.println("Has muerto, Fin del juego.");
        } else {
            System.out.println("Has alcanzado 50 puntos de experiencia, Escapas de la Dimensión Mágica. GANASTE");
        }
    }
}