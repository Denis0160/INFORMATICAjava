import java.util.Scanner;

public class Denis_3E_Es07_VettoreBool {
    public static void main(String[] Args){
        Scanner tastiera=new Scanner(System.in);
        String parola;

        System.out.println("Inserisci la stringa \n");
        parola=tastiera.nextLine();


        boolean[] alfabeto= new boolean[26];

        for(int i=0; i<parola.length(); i++){
            char carattere=parola.charAt(i);

            //Verifica se è un carattere dell'alfabeto o meno
            if (Character.isLetter(carattere)) {
                alfabeto[carattere-'a']=true; //L'indice dell'array viene
                // calcolato sottraendo 'a' dal valore ASCII del carattere.
                //Il valore ASCII di 'a' è 97.
                //Il valore ASCII di 'b' è 98.
                //Quando si sottrae 'a' da 'b', otteniamo 98 - 97 = 1.
            }
        }
        System.out.println("Caratteri presenti nella stringa:");
        //ciclo for per stampare i caratteri presenti
        for (char c='a'; c<='z';c++) {
            if (alfabeto[c-'a']) {
                System.out.print(c+" ");
            }
        }

        System.out.println("\nCaratteri non presenti nella stringa:");
        //Ciclo for per stampare i caratteri false
        for (char c='a';c<='z';c++) {
            if (!alfabeto[c-'a']) {
                System.out.print(c +" ");
            }
        }

    }

}
