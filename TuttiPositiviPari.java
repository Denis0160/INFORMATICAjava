import java.util.Scanner;
public class TuttiPositiviPari {
    public static void main(String[] Args){
        /*1-Scrivere un programma TuttiPositiviPari che chiede all’utente di inserire una
        sequenza di interi (chiedendo prima quanti numeri voglia inserire) e poi, al
        termine dell’inserimento dell’intera sequenza all’interno di un array, stampa
        "Tutti positivi e pari" se i numeri inseriti sono tutti positivi e pari,
                altrimenti stampa "NO".
                Bonus: utilizzare un metodo per determinare se il vettore contiene tutti
        Positivi e Pari.*/

        Scanner tastiera=new Scanner(System.in);

        int dim;

        System.out.println("Quanti numeri vuoi inserire?\n");
        dim=tastiera.nextInt();

        int[] vet=new int[dim];

        System.out.println("Inserisci i numeri nel vettore\n");

        for(int i=0; i<dim;i++){
            vet[i]=tastiera.nextInt();
        }
        boolean[] controllo=new boolean[dim];

        for(int i=0;i<dim;i++){
            controllo[i]=false;
        }
        int cont=0;
        for(int i=0;i<dim;i++){
            if(vet[i]>0 && vet[i]%2==0){
                controllo[i]=true;
                cont++;
            }
        }

       if(cont==dim){
           System.out.println("Tutti positivi e pari!\n");

       }else{
           System.out.println("NO\n");
       }




    }
}
