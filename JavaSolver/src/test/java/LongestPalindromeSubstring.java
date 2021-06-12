import org.junit.jupiter.api.Test;

public class LongestPalindromeSubstring {

    @Test
    public void run() {
        String input =
//                "cbbd";
                "babaddddadd";
        System.out.println(solution(input));
    }

    private String solution(String input) {
        String rev = new StringBuilder(input).reverse().toString();
        if (input.length() < 2 || input.equals(rev)) {
            return input;
        }

        String max = "";
        for (int i = 0; i < input.length() - 1; i++) {
            String even = expand(i, i + 1, input);
            String odd = expand(i, i + 2, input);
            String temp;

            if (even.length() < odd.length()) {
                temp = odd;
            } else {
                temp = even;
            }

            if (max.length() < temp.length()) {
                max = temp;
            }
        }
        return max;
    }

    private String expand(int left, int right, String str) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
