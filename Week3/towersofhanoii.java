import java.util.*;

public class Main {
    static Stack<Integer> a = new Stack<>();
    static Stack<Integer> b = new Stack<>();
    static Stack<Integer> c = new Stack<>();

    static void move(Stack<Integer> x, Stack<Integer> y, char a, char b) {
        if (x.isEmpty() || (!y.isEmpty() && x.peek() > y.peek())) {
            x.push(y.pop());
            System.out.println("Move " + x.peek() + " from " + b + " to " + a);
        } else {
            y.push(x.pop());
            System.out.println("Move " + y.peek() + " from " + a + " to " + b);
        }
    }

    static void hanoi(int n) {
        for (int i = n; i > 0; i--) a.push(i);

        int moves = (1 << n) - 1;

        for (int i = 1; i <= moves; i++) {
            if (n % 2 == 1) {
                if (i % 3 == 1) move(a, c, 'A', 'C');
                else if (i % 3 == 2) move(a, b, 'A', 'B');
                else move(b, c, 'B', 'C');
            } else {
                if (i % 3 == 1) move(a, b, 'A', 'B');
                else if (i % 3 == 2) move(a, c, 'A', 'C');
                else move(b, c, 'B', 'C');
            }
        }
    }

    public static void main(String[] args) {
        hanoi(4);
    }
}
