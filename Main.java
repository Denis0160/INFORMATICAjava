
import java.util.Scanner;
public class Main {
    private static void main(String[] Args){
        /*
        Scrivere un programma DueSequenze che lette da input due sequenze di
stringhe, ciascuna di 5 elementi, stampa il messaggio "OK" se almeno una stringa
della prima sequenza compare anche nella seconda, altrimenti stampa il messaggio
"NO".
Bonus: utilizzare un metodo per inserire i dati all’interno dei vettori di
stringhe e, nel caso in cui le due sequenze abbiano almeno una stringa in
comune, interrompere i confronti.
         */

        Scanner tastiera=new Scanner(System.in);

        String[] prima=new String[5];
        String[] seconda=new String[prima.length];

        for(int i=0;i<prima.length;i++){
            prima[i]=tastiera.nextLine();
        }

        for(int i=0;i<prima.length;i++){
            seconda[i]=tastiera.nextLine();
        }

        Boolean[] controllo=new Boolean[prima.length];
        int cont=0;

        for(int i=0;i< prima.length;i++){
            controllo[i]=false;
        }

        for(int i=0;i< prima.length;i++){
            for(int j=0;j<seconda.length;i++){

                if(prima[i]==seconda[j]){
                    controllo[i]=true;
                    cont++;
                }
            }
        }

        for(int i=0;i< prima.length;i++){
            if(controllo[i]){
                System.out.println("OK\n");
                return;
            }
            System.out.println("NO\n");
        }
    }


}

