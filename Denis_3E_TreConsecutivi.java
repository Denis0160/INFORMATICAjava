public class Denis_3E_TreConsecutivi {

        public static void main(String[] args) {
            int[] numeri ={1,22,2,4,5,6,7,7};

            // mettiamo -2 nella lunghezza perchè abbiamo da confrontare tre elementi e
            //dobbiamo fermarci 2 elementi prima dell'ultimo
            for (int i=0; i<numeri.length-2;i++){
                if (numeri[i]==numeri[i+1] && numeri[i]==numeri[i+1+1])
                {
                    // Se troviamo tre valori consecutivi uguali, stampiamo il messaggio e usciamo dal programma
                    System.out.println("Tre valori consecutivi uguali");
                    return;
                }
            }
            System.out.println("NO");
        }
    }


