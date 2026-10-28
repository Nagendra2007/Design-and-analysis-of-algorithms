public class ReverseString {
    // Reverses a string by Unicode code points to correctly handle emojis and surrogate pairs
    public static String reverse(String s) {
        if (s == null) return null; // simple null check
        int[] codePoints = s.codePoints().toArray(); // convert to code points
        // Two-pointer swap to reverse the array in-place
        for (int i = 0, j = codePoints.length - 1; i < j; i++, j--) {
            int tmp = codePoints[i];
            codePoints[i] = codePoints[j];
            codePoints[j] = tmp;
        }
        return new String(codePoints, 0, codePoints.length); // build string from reversed code points
    }

    public static void main(String[] args) {
        // Small example
        String input = "Hello, 🌍!";
        String reversed = reverse(input);
        // Print the output
        System.out.println("Input:    " + input);
        System.out.println("Reversed: " + reversed);
    }
}