import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class RemoveDuplicateLetters {
    
    @Test
    public void run() {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr);
        Stack<String> stack = new Stack<>();

        for (String ch : arr) {
            if (stack.isEmpty() || !stack.peek().equals(ch)) {
                stack.add(ch);
            }
        }

        return String.join("", stack);
    }
}
