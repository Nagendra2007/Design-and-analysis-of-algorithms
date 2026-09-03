public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5,856,54,20,56,023,53,12};
        mergeSort(arr,0,arr.length-1);
        
        for(int n : arr) 
        System.out.print(n + " ");
    }

    static void mergeSort(int arr[],int low , int high){
        if(low<high) {
            int mid =  (low + high)/2;

            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);

            merge(arr,low,mid,high);
        }
    }

    static void merge(int arr[] , int low , int mid , int high) {
        int temp[] = new int[high-low+1];

        int i = low;
        int j = mid+1;

        int k = 0;

        while(i<=mid && j<=high) {
            if(arr[i]<arr[j]) {
                temp[k++] = arr[i++];
            }
            else
                temp[k++] = arr[j++];
        }

        while(i<=mid) {
            temp[k++]  = arr[i++];
        }

        while(j<=high) {
            temp[k++] = arr[j++];
        }

        k = 0;
        for( ;k<temp.length ; k++) {
            arr[low++] = temp[k];
        }
    }
}
