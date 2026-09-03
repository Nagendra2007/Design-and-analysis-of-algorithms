import java.util.*;

public class BucketSort {

    public static void main(String[] args) {
        int arr[] = {10,18,27,35,42,51,59,66,77};

        int min = arr[0];
        int max = arr[0];

        for(int n : arr) {
            if(n<min) 
                min = n;
            if(n>max) 
                max = n;
        }

        int range = (max-min)/arr.length;

        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(arr.length);

        for(int i=0 ; i<arr.length ; i++) {
            bucketList.add(new ArrayList<>());
        }

        for(int n : arr) {
            int index = Math.min((n-min)/(range==0 ? 1 : range),arr.length-1);
            bucketList.get(index).add(n);
        }


        for(ArrayList<Integer> list : bucketList) {
            Collections.sort(list);
        }

        int k = 0;
        for(ArrayList<Integer> list : bucketList) {
            if(list!=null) {
                for(int n : list) {
                    arr[k++] = n;
                }
            }
        }


        for(int n : arr) {
            System.out.print(n+" ");
        }
    }
    
}
