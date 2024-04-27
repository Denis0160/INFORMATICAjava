public class Algoritmi {
    public static void main(String[] Args) {
        int[] array={7,10,34,2,6,9,12,56,23};

        selectionSort(array);


    }
    public static void selectionSort(int[] array){
        int n=array.length;//dimensione array

        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(array[j]<array[min])
                    min=j;
            }
            int temp=array[min];
            array[min]=array[i];
            array[i]=temp;
        }
        for(int i=0;i<n;i++){
            System.out.println(array[i]+"");
        }
        System.out.println();
    }
}
