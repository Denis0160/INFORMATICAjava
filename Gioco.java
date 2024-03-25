import java.util.Scanner;
import Menu.MetodoMenu;

public class GiocoFiammiferi {

    public static void main(String[] Args){
        Scanner scanner=new Scanner(System.in);
        
        
        int giocatoreUno=0, giocatoreDue=0, fiammiferi=4;
        
        String errore="errore!!! il numero supera 3\n";

        System.out.println("-------------------------------------\n");
        System.out.println("Benvenuti al gioco dei fiammiferi!\n");
        System.out.println("-------------------------------------\n");

        System.out.println("Inizia il giocatore 1\n");
        Wait();
        ClrScr();
        System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("| | | | | | | | | | | | | | | | | | | | |\n");
        System.out.println("\n");

        while(fiammiferi>0){
            System.out.println("Giocatore uno inserisci il numero di fiammiferi che vuoi togliere:\n");
            giocatoreUno=scanner.nextInt();
            try {
                if (giocatoreUno > 3)
                    System.out.println(errore);
            } catch (Exception x) {
                giocatoreUno = 3;
                continue;
            }

            fiammiferi = fiammiferi - giocatoreUno;

            if(fiammiferi<=0){
                System.out.println("Ha vinto il giocatore 1");
                break;
            }


            Wait();
            ClrScr();

            System.out.println("Giocatore 2 inserisci il numero di fiammiferi che vuoi togliere:\n");

            try {
                giocatoreDue = scanner.nextInt();
                if (giocatoreDue > 3) {
                    System.out.println(errore);
                }
            } catch (Exception x) {
                giocatoreDue = 3;
                continue;
            }

            fiammiferi = fiammiferi - giocatoreDue;

            if(fiammiferi<=0) {
                System.out.println("Ha vinto il giocatore 2");
                break;
            }

        }


    }
   

    
}
