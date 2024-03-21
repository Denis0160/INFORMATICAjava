package Gioco;


import java.util.Scanner;

public class Gioco {

    public static void main(String[] Args){
        Scanner scanner=new Scanner(System.in);
         int giocatoreUno=0, giocatoreDue=0, fiammiferi=4;
         int gUno=0, gDue=0;
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
            gUno++;
            if(fiammiferi<=0)
                break;

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
            if(fiammiferi<=0)
                break;
        }

        if(gUno<gDue){
            System.out.println("Ha vinto il giocatore Uno\n");
        }else if(gUno>gDue){
            System.out.println("Ha vinto il giocatore Due\n");
        }

    }
    public static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait() {
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
