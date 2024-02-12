import java.util.Scanner;
public class Denis_3E_ArrayStringhe {
    public static void main(String[] Args){
        String[] stringhe=new String[5];
        Scanner scanner=new Scanner(System.in);

        for(int i=0;i< stringhe.length;i++) {
            System.out.println("Inserisci la stringa\n");
            stringhe[i] = scanner.nextLine();
        }

            System.out.println("Le stringhe che iniziano con la lettera maiuscola sono:\n");
            for(int j=0;j<stringhe.length;j++){
                if(Character.isUpperCase(stringhe[j].charAt(0))){
                    System.out.println(stringhe[j]);
                }
            }

        }

    }

