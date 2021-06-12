import org.junit.jupiter.api.Test;

public class ValidPalindrome {

    @Test
    public void run() {
        System.out.println(
                solution("race a car"));
    }

    private boolean solution(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }

        for (int i = 0; i <= str.length() / 2; i++) {
            int j = str.length() - i - 1;
            char h = str.charAt(i);
            char t = str.charAt(j);
            if (h != t) {
                return false;
            }
        }
        return true;
    }
}
