import java.util.Arrays;
import java.util.Scanner;
 
public class FractionalKnapsack {
 
    static class Item {
        int weight, value;
        Item(int w, int v) { weight = w; value = v; }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        System.out.println("Enter weight and value of each item:");
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            items[i] = new Item(w, v);
        }
        System.out.print("Enter capacity of knapsack: ");
        double capacity = sc.nextDouble();
 
        Arrays.sort(items, (x, y) ->
            Double.compare((double) y.value / y.weight, (double) x.value / x.weight));
 
        double totalValue = 0;
        for (Item item : items) {
            if (capacity <= 0) break;
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * (capacity / item.weight);
                capacity = 0;
            }
        }
        System.out.println("Maximum value in knapsack = " + totalValue);
        sc.close();
    }
}
