public class Palindrome {

    // Returns true if the given string is a palindrome (ignoring non-alphanumeric and case)
    public static boolean isPalindrome(String s) {
        if (s == null) return false; // null is not a palindrome

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);

            // Skip non-alphanumeric on the left
            if (!Character.isLetterOrDigit(cl)) {
                left++;
                continue;
            }
            // Skip non-alphanumeric on the right
            if (!Character.isLetterOrDigit(cr)) {
                right--;
                continue;
            }

            // Compare characters in a case-insensitive manner
            if (Character.toLowerCase(cl) != Character.toLowerCase(cr)) {
                return false; // mismatch means it's not a palindrome
            }

            // Move both pointers inward
            left++;
            right--;
        }

        return true; // all checks passed
    }

    public static void main(String[] args) {
        // Small examples to demonstrate the function
        String example1 = "A man, a plan, a canal: Panama";
        String example2 = "race a car";
        String example3 = "madam";

        // Print results
        System.out.println(isPalindrome(example1)); // true
        System.out.println(isPalindrome(example2)); // false
        System.out.println(isPalindrome(example3)); // true
    }
}