import java.util.Scanner;
public class Data {
    public static void main(String[] Args){

        int [] data=new int[3];
        int j=0;

        Scanner scanner=new Scanner(System.in);
        System.out.println("Inserisci la data\n");

        for(int i=0;i< data.length;i++){
            data[i]=scanner.nextInt();
        }

        System.out.println("\nGiorno:"+data[j]);
        System.out.println("\nmese:"+data[j+1]);
        System.out.println("\nAnno:"+data[j+2]);

    }
}
