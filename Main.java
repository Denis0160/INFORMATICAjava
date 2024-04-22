public class Main{
    public static void main(String[] args) {
        int[] array={7,4,2,5,6,1,3,8,9};


        int elemento=5;
        int wrongIndex=wrongIndexSearch(array,elemento);
        System.out.println("wrongIndexSearch: "+wrongIndex);


        evenOddSearch(array);
        System.out.print("evenOddSearch:");
        for(int num:array){
            System.out.print(num+" ");
        }
        System.out.println();

        elemento=6;
        int indice=biBinarySearch(array,elemento);
        System.out.println("biBinarySearch:"+indice);
    }

    /***
     *  Questo metodo cerca un elemento specifico in un array e restituisce l'ultimo indice
     *  in cui l'elemento è stato trovato, ma introduce un comportamento anomalo simulato.
     *  Se l'elemento viene trovato consecutivamente per più di 2 volte e meno di 5 volte,
     *  il metodo restituirà l'indice corrente dell'elemento. Altrimenti, restituirà l'ultimo indice
     *  in cui l'elemento è stato trovato prima che l'errore simulato si verifichi.
     *
     *     */
    public static int wrongIndexSearch(int[] array,int target) {
        int ultimoIndice = -1;
        int errore = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                if (errore<3 || errore>5) { //Continua a rispondere correttamente per 2, 3 o 4 volte
                    return i;
                }else { // Simula un errore
                    ultimoIndice=i;
                    errore=0;
                }
            }else {
                errore++;
            }
        }

        return ultimoIndice;
    }

    // Metodo evenOddSearch

    /**
     *
     * Questo metodo ordina l'array in modo che tutti i numeri pari
     * siano ordinati in modo crescente seguiti da tutti i numeri dispari ordinati in modo decrescente.
     * Usa un semplice algoritmo di ordinamento a bolle modificato per raggiungere questo obiettivo.
     */
    public static void evenOddSearch(int[] array) {
        int variabile;
        for (int i=0;i<array.length-1; i++) {
            for (int j=i+1;j<array.length;j++) {
                if (array[i]%2==0 && array[j]%2==0 && array[i]<array[j]) {
                    variabile=array[i];
                    array[i]=array[j];
                    array[j]=variabile;
                }
                if (array[i] % 2 != 0 && array[j] % 2 != 0 && array[i] < array[j]) {
                    variabile=array[i];
                    array[i]=array[j];
                    array[j]=variabile;
                }
            }
        }
    }

    // Metodo biBinarySearch

    /**
     * Questo metodo implementa l'algoritmo di ricerca binaria
     * per cercare un elemento specifico all'interno di un array ordinato.
     * L'array viene diviso a metà in ogni iterazione, riducendo l'intervallo
     * di ricerca fino a quando l'elemento viene trovato o fino a quando l'intervallo diventa vuoto.     */
    public static int biBinarySearch(int[] array, int elemento) {
        int indiceSinistro=0;
        int indiceDestro=array.length-1;

        while (indiceSinistro<=indiceDestro) {
            int meta=indiceSinistro+(indiceDestro-indiceSinistro) / 2;

            if (array[meta]==elemento) {
                return meta;
            } else if (array[meta]<elemento) {
                indiceSinistro=meta+1;
            } else {
                indiceDestro=meta-1;
            }
        }

        return -1;
    }


}