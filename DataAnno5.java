import java.util.Scanner;

public class DataAnno5 {
    public static void main(String[] Args){



                Scanner scanner=new Scanner(System.in);

                int[] data=new int[3];
                int j=0;
                int k=1;
                int cont;
                int l=0;
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
                    if(data[k]==4 || data[k]==6 || data[k]==9 || data[k]==11){
                        do{
                            data[i]=scanner.nextInt();
                        }while(data[l]<0||data[l]>30);
                    }

                }

                cont=data[j+1];
                System.out.println("\ngiorno:"+data[j]);
                System.out.println("\nMese:"+mesi[cont-1]);
                System.out.println(("\nanno:"+data[j+2]));



            }

        }
