import java.util.Scanner;
public class dataAnno01 {
    public static void main(String[] Args){

        Scanner scanner=new Scanner(System.in);

        int[] data=new int[3];
        int j=0;
        int k=1;
        int cont;
        String[] mesi={"gennaio","febbraio", "marzo"
                ,"aprile"," maggio", "giugno"
                ,"luglio", "agosto",
                "settembre"," ottobre",
                "novembre","dicembre"};

        System.out.println("inserisci la data:\n");
        for(int i=0;i< data.length;i++){
            do {
                data[i] = scanner.nextInt();

            }while(data[k]<0 || data[k]>12);

        }
        cont=data[j+1];
        System.out.println("\ngiorno:"+data[j]);
        System.out.println("\nMese:"+mesi[cont-1]);
        System.out.println(("\nanno:"+data[j+2]));



    }

}
