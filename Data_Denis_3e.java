import java.util.Scanner;

public class Data_Denis_3e {
    public static void main(String[] Args){

        Scanner scanner=new Scanner(System.in);

        int data;
        boolean continua=false;


        String[] mesi={"gennaio","febbraio", "marzo"
                ,"aprile"," maggio", "giugno"
                ,"luglio", "agosto",
                "settembre"," ottobre",
                "novembre","dicembre"};

        do {
            System.out.println("inserisci la data:\n");

            data = scanner.nextInt();

            String dataS = Integer.toString(data);
            String giorno = dataS.substring(0, 2);
            String mese = dataS.substring(2, 4);
            String anno = dataS.substring(4, 8);

            int meseI = Integer.parseInt(mese);
            int giornoI = Integer.parseInt(giorno);
            int annoI = Integer.parseInt(anno);

            if (meseI > 12 || meseI < 0) {
                System.out.println("\nIl mese inserito non è valido");
                continua=true;
            } else if (meseI==4 || meseI==6 || meseI==9 || meseI==11 && giornoI>30 || giornoI<0) {
                System.out.println("\nHai inserito una data errata");
                continua=true;
                
            } else if((annoI % 4 == 0 && annoI % 100 != 0) || annoI % 400 == 0 && meseI==2 && giornoI>28){
                System.out.println("\nAnno bisestile");
                continua=true;
            }
            else {

                System.out.println("\ngiorno:" + giornoI);
                System.out.println("\nMese:" + mesi[meseI - 1]);
                System.out.println(("\nanno:" + annoI));
            }

        }while(continua);


    }


}