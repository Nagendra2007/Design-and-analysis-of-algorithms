import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter table size: ");
        int size = sc.nextInt();
        int[] table = new int[size];
        boolean[] filled = new boolean[size];
        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            int index = key % size;
            int j = 0;
            int newIndex = index;
            while (filled[newIndex]) {
                j++;
                newIndex = (index + j * j) % size;
            }
            table[newIndex] = key;
            filled[newIndex] = true;
        }
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            if (filled[i]) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": -");
            }
        }
        sc.close();
    }
}
