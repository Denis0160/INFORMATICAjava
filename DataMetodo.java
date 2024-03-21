import java.util.Scanner;
public class DataMetodo {
    public static void main(String[] Args){
        String mese;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Inserisci il mese:");
        mese=scanner.next();

        System.out.println(intToStrMese(mese));


    }
    private static int intToStrMese(String mese){
     String[] mesi={"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto"
     ,"Settembre","Ottobre","Novembre","Dicembre"};

     for(int i=0;i<mesi.length;i++){
        if(mesi[i].equalsIgnoreCase(mese)) {
            return i+1;
        }
     }
    return -1;
    }

}

