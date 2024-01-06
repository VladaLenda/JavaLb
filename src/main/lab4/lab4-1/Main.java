public class Main {

    public static void main(String[] args) {
        String input = "mom";
        PalindromeChecker checker = new PalindromeChecker(input);
        if (checker.isPalindrome()) {
            System.out.println("This code is a palindrome.");
        } else {
            System.out.println("This code is not a palindrome.");
        }
    }
}

class PalindromeChecker {

    private String input;

    public PalindromeChecker(String input) {
        this.input = input;
    }

    public boolean isPalindrome() {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}