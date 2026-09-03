public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {12,85,10,69,52,21,45,35,15,2,99};
        quickSort(arr);
        for(int n : arr) 
            System.out.print(n+" ");
    }
    
    public static void quickSort(int arr[]) {
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int arr[],int low , int high) {
        if(low<high) {
            int pivot = partition(arr,low,high);

            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    public static int partition(int arr[],int low,int high) {
        int pivot = arr[high];
        int i = 0;

        for(int j=0; j<high ; j++) {
            if(arr[j]<pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

            int temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;

      return i;
        
    }
    
}
