import java.util.Scanner;

public class Secondi {
    public static void main(String[] args) {

        // Declaration of variables for hours, minutes and seconds
        int secondi = 0, minuti = 0, ore = 0;

        // Create a Scanner object to read keyboard input
        Scanner tastiera = new Scanner(System.in);

        // Do-while loop to ensure the user enters a valid value of seconds
        do {
            System.out.println("Inserisci i secondi trascorsi:  ");
            secondi = tastiera.nextInt();
            if (secondi > 86400) {
                System.out.println("Hai inserito più di un giorno, reinserisci il valore dei secondi! ");
            }
        } while (secondi > 86400);

        // Check and convert seconds to hours, minutes and seconds
        if (secondi < 60) {
            System.out.println("Sono trascorsi  " + ore + " (ore)  " + minuti + " (minuti)  " + secondi + " (secondi) ");
        }

        // Calculate minutes without the need for a do-while loop
        minuti = secondi / 60;
        secondi = secondi - (60 * minuti);

        // Calculate hours without the need for a do-while loop
        ore = minuti / 60;
        minuti = minuti - (60 * ore);

        // Print the result
        System.out.println("Sono trascorsi  " + ore + " (ore)  " + minuti + " (minuti)  " + secondi + " (secondi) ");
    }
}
