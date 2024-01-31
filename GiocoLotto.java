import java.util.Scanner;
import java.util.Random;
public class GiocoLotto {
    public static void main(String[] Args) {
        int scelta;
        int sceltaruota1;
        int N;
        Scanner tastiera = new Scanner(System.in);

        String[] opzioni = {"=== Gioco Lotto === ",
                "Su quante ruote vuoi giocare?",
                "[1] Una ruota",
                "[2] Dieci ruote",
                "[3] Esci",};
        scelta = Menu(opzioni, tastiera);
            switch(scelta){
                case 1:{
                    System.out.println("quante ruote?");
                    sceltaruota1 = tastiera.nextInt();
                    Ruota1(sceltaruota1);
                }
            }
    }

    private static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {

            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");

            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }
    private static int numRand()  // metodo per estrarre il dado
    {

        Random num = new Random();
        return num.nextInt(91);

    }

    private static void Ruota1(int sceltaruota1) {
        int numeroruote=0;
        int[] numeriruote=new int[50];
        int P=0;
        switch(sceltaruota1){
            case 1:{
                numeroruote=5;
                P=1;
            }
            case 2:{
                numeroruote=50;
                P=5;
            }
        }
        for (int i = 0; i < P; i++) {
            System.out.println("°ruota:\n");
            for (int k = 0; k < numeroruote; k++) {
                numeriruote[k] = numRand();
                System.out.println("."+numeriruote[i]);
            }
        }




    }





    private static int NumeroDiNumeriDaGiocare() {
        Scanner scanner = new Scanner(System.in);
        int quantità;
        int scelta;
        int importo=0;

        do {
            System.out.print("Inserisci quanti numeri vuoi giocare (da 1 a 5): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input non valido. Inserisci un numero da 1 a 5.");
                scanner.next();
            }
            quantità = scanner.nextInt();
        } while (quantità < 1 || quantità > 5);

        switch(quantità){
            case 1:{
                System.out.println("Vuoi puntare su Ambo?\n" +
                        "\n1)si" +
                        "\n2)no");
                scelta= scanner.nextInt();
                if(scelta==1){
                  System.out.println("\nQuanto vuoi puntare su Ambo?");
                  importo=scanner.nextInt();
                }else{
                    break;
                }
            }
        }

        return quantità;
    }

}


