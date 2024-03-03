import java.util.Scanner;
public class Uovo{
    public static void main(String[] Args) {
        Scanner tastiera=new Scanner(System.in);
        String risposta="";
        String opzione="";
        UovoNonBolle();
        do {
            System.out.println("Premi S per bollire l'uovo");
             risposta=tastiera.nextLine();
        }while(!(risposta.equals("S") || risposta.equals("s")) );
        ClrScr();

        if(risposta.equals("s") || risposta.equals("S")){
            UovoCheBolle();
            Wait();
            ClrScr();
            UovoPronto();


        }


    }


    private static void Wait() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void UovoNonBolle() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }

    private static void UovoCheBolle() {
        System.out.println("~~~~~~  _______~~~~~~");
        System.out.println("~~~~~~ /       \\~~~~~~");
        System.out.println("~~~~~~/         \\~~~~~~");
        System.out.println("~~~~~~|           |~~~~~~");
        System.out.println("~~~~~~\\         /~~~~~~");
        System.out.println("~~~~~~ \\_______/~~~~~~");
    }

    private static void UovoPronto() {
        System.out.println("   _______");
        System.out.println("  /       \\");
        System.out.println(" /         \\");
        System.out.println("|     O     |");
        System.out.println(" \\         /");
        System.out.println("  \\_______/");
    }


        private static void ClrScr(){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}
