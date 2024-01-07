import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PalindromeCheckerTest {

    @Test
    public void testIsPalindrome() {
        String input = "mom";
        PalindromeChecker checker = new PalindromeChecker(input);
        assertEquals(true, checker.isPalindrome());
    }

    @Test
    public void testIsNotPalindrome() {
        String input = "hello";
        PalindromeChecker checker = new PalindromeChecker(input);
        assertEquals(false, checker.isPalindrome());
    }
}