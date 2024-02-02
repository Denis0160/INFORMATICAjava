import java.util.Scanner;
import java.util.Random;
public class GiocoLotto {
    public static void main(String[] Args) {
        int scelta,dim=0;
        double puntata1=0, puntata2=0, puntata3=0, puntata4=0, puntata5=0;
        boolean s1=false,s2=false,s3=false,s4=false,s5=false;
        int cont1=0,cont2,cont3,cont4,cont5;
        int sceltapuntata=0;
        int[] NumUtente=new int[5];
        Scanner tastiera = new Scanner(System.in);

        System.out.println("=== Gioco Lotto === \nSu quante ruote vuoi giocare?\n");
        String[] opzioni = {"[1] Una ruota",
                            "[2] Dieci ruote",
                            "[3] Esci",};
        scelta = Menu(opzioni, tastiera);

        switch(scelta){
            case 1:{
                dim=5;
                break;
            }
            case 2:{
                dim=50;
                break;
            }
        }
        int[] ruotaN=new int[dim];
        for(int i=0;i< ruotaN.length;i++) {
            ruotaN[i] = numRand(1, 90);
            System.out.println(ruotaN[i]);
        }

        System.out.println("Gioca i numeri");
        for(int i=0;i<5;i++){
            NumUtente[i]=tastiera.nextInt();
            System.out.println(NumUtente[i]);
        }
        do{
            System.out.println("----Scegli su cosa puntare----");
            System.out.println("[1]singolo");
            System.out.println("[2]Ambo");
            System.out.println("[3]terna");
            System.out.println("[4]quterna");
            System.out.println("[5]cinquina");
            System.out.println("[6]Continua");
            sceltapuntata=tastiera.nextInt();
            switch (sceltapuntata){
                case 1:{
                    if(s1==false){
                        System.out.println("Hai scelto di puntare su singolo!");
                        s1=true;
                        do {
                            System.out.println("Quanto vuoi puntare??");
                            puntata1 = tastiera.nextDouble();
                        }while(puntata1<0.50 || puntata1>200);
                    }
                    else if(s1==true)
                    {
                        System.out.println("Hai Gia scelto singolo");

                    }
                    break;
                }
                case 2:{
                    if(s2==false){
                        System.out.println("Hai scelto di puntare su ambo!");
                        s2=true;
                        do {
                            System.out.println("Quanto vuoi puntare??");
                            puntata2 = tastiera.nextDouble();
                        }while(puntata2<0.50 || puntata2>200);
                    }
                    else if(s2==true)
                    {
                        System.out.println("Hai Gia scelto ambo");
                    }
                    break;
                }
                case 3:{
                    if(!s3){
                        System.out.println("Hai scelto di puntare su terna!");
                        s3=true;
                        do {
                            System.out.println("Quanto vuoi puntare??");
                            puntata3 = tastiera.nextDouble();
                        }while(puntata3<0.50 || puntata3>200);
                    }
                    else if(s3)
                    {
                        System.out.println("Hai Gia scelto terna");
                    }
                    break;
                }
                case 4:{
                    if(!s4){
                        System.out.println("Hai scelto di puntare su quaterna!");
                        s4=true;
                        do {
                            System.out.println("Quanto vuoi puntare??");
                            puntata4 = tastiera.nextDouble();
                        }while(puntata4<0.50 || puntata4>200);
                    }
                    else if(s4)
                    {
                        System.out.println("Hai Gia scelto quaterna");
                    }
                    break;
                }
                case 5:{
                    if(!s5){
                        System.out.println("Hai scelto di puntare su cinquina!");
                        s5=true;
                        do {
                            System.out.println("Quanto vuoi puntare??");
                            puntata5= tastiera.nextDouble();
                        }while(puntata5<0.50 || puntata5>200);
                    }
                    else if(s5)
                    {
                        System.out.println("Hai Gia scelto cinquina");
                    }
                    break;
                }
            }
        }while(sceltapuntata!=6);

        for (int i = 0; i < NumUtente.length; i++) {
            for (int k = 0; k < ruotaN.length; k++) {
                if (NumUtente[i] == ruotaN[k]) {
                    cont1++;
                }
            }
        }
        System.out.println("------------------"+cont1);

    }

    private static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {

            System.out.println(opzioni[0]);
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait();
                ClrScr();



            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }
    //METODO RANDOM
    private static int numRand(int minValue, int maxValue) {

        Random num = new Random();
        return num.nextInt(maxValue)+minValue;

    }



        private static void ClrScr(){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    private static void Wait() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
