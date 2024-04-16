import java.util.Scanner;

public class Menu {

    public static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta;

        do {
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = Integer.parseInt(keyboard.nextLine());
            if(scelta<1 || scelta>opzioni.length-1)
            {
                System.out.println("Valore errato. Riprova");
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }
}

