//Author:Sescu Denis
//Data:28/11/2023
/*Vinaio in java*/

import java.util.Scanner;
public class Vinaio
{
    public static void main(String[] args) {
        double prezzo=1.5, finale, iva=21, litro=1.5,litriF;//variable declaration


        System.out.println("BENVENUTI NEL NOSTRO NEGOZIO DI VINI!!!");
        System.out.printf("Il prezzo di una bottiglie è di: %.2f euro ", prezzo);//price display
        System.out.println("\nQUANTE BOTTIGLIE VUOI AQUISTARE??");//asks the user how many bottles he wants to purchase
        Scanner scanner= new Scanner(System.in);//creation of the input keyboard
        double quantita= scanner.nextInt();//entering the quantity
        if(quantita==0)//check if the quantity entered is correct
        {
            System.out.println("Hai inserito una quantità errata!!");

        }
        /*if the quantity is correct then calculate the price
        and VAT based on the number of bottles purchased*/

        else{

            finale=(iva/100)*(quantita*prezzo)+(quantita*prezzo);
            litriF=quantita*litro;
            System.out.printf("Hai comprato: %.2f litri di vino\n",litriF);
            System.out.printf("Devi pagare:%.2f euro",finale);
        }

    }
}