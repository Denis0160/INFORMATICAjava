public class QuickSort {
    public static void main(String[] args) {
        int[] array = {7, 2, 1, 6, 8, 5, 3, 4};

        quickSort(array);

        System.out.println("Array ordinato:");
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }

    // Metodo principale per avviare il Quick Sort
    public static void quickSort(int[] array) {
        // Chiamata al metodo di supporto per eseguire il Quick Sort
        quickSort(array, 0, array.length - 1);
    }

    // Metodo di supporto per eseguire il Quick Sort ricorsivamente
    private static void quickSort(int[] array, int inizio, int fine) {
        // Se l'indice di inizio è maggiore o uguale all'indice di fine, non c'è nulla da ordinare
        if (inizio >= fine) {
            return;
        }

        // Partiziona l'array e ottiene l'indice del pivot
        int indicePivot = partiziona(array, inizio, fine);

        // Richiama ricorsivamente quickSort sulle due metà dell'array
        quickSort(array, inizio, indicePivot - 1); // Parte sinistra del pivot
        quickSort(array, indicePivot + 1, fine);   // Parte destra del pivot
    }

    // Metodo per partizionare l'array e restituire l'indice del pivot
    private static int partiziona(int[] array, int inizio, int fine) {
        // Scegli un elemento pivot, ad esempio l'ultimo elemento dell'array
        int pivot=array[fine];

        // Inizializza l'indice del pivot al punto di inizio
        int indicePivot=inizio;

        // Itera attraverso l'array (escludendo l'ultimo elemento che è il pivot)
        for (int i = inizio; i < fine; i++) {
            // Se l'elemento corrente è minore o uguale al pivot, lo scambia con l'elemento a indicePivot
            if (array[i]<=pivot) {
                scambia(array, i, indicePivot);
                indicePivot++; // Incrementa l'indice del pivot
            }
        }

        // Alla fine, scambia il pivot con l'elemento a indicePivot
        scambia(array, indicePivot, fine);

        // Restituisce l'indice del pivot
        return indicePivot;
    }

    // Metodo per scambiare due elementi in un array
    private static void scambia(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    // Metodo per stampare l'array



}
