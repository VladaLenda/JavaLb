import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    private static final Pattern vowelPattern = Pattern.compile("([12345])");
    private static final Pattern consonantPattern = Pattern.compile("(.)\\1*", Pattern.CASE_INSENSITIVE);

    public static String decode(String input) {
        String[] words = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (String word : words) {
            if (isVowelEncoded(word)) {
                word = decodeVowels(word);
            } else if (isConsonantEncoded(word)) {
                word = decodeConsonants(word);
            }
            output.append(word).append(" ");
        }

        return output.toString().trim();
    }

    private static boolean isVowelEncoded(String word) {
        return vowelPattern.matcher(word).find();
    }

    private static boolean isConsonantEncoded(String word) {
        return consonantPattern.matcher(word).find();
    }

    private static String decodeVowels(String word) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        String[] numbers = {"1", "2", "3", "4", "5"};

        for (int i = 0; i < vowels.length; i++) {
            word = word.replaceAll(numbers[i], vowels[i]);
        }

        return word;
    }

    private static String decodeConsonants(String word) {
        char[] chars = word.toCharArray();
        StringBuilder output = new StringBuilder();

        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                char nextChar = c;
                while (nextChar == c) {
                    nextChar++;
                }
                output.append(nextChar);
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("t2st3ng v2rtiph"));
    }
}