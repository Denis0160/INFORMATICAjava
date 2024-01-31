import java.util.Scanner;
import java.util.Random;
public class Main {
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
                int[] ruotaD=new int[5];
                for(int i=0;i<ruotaD.length;i++){
                    ruotaD[i]=numRand(1,90);
                    System.out.println(ruotaD[i]);
                    break;
                }
            }
            case 2:{
                int[] ruotaN=new int[50];
                for(int i=0;i<ruotaN.length;i++){
                    ruotaN[i]=numRand(1,90);
                    System.out.println(ruotaN[i]);
                }
                
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
    //METODO RANDOM 
    private static int numRand(int minValue, int maxValue) { 

        Random num = new Random();
        return num.nextInt(maxValue-minValue)+minValue;

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

