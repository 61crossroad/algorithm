import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class RemoveDuplicateLetters {
    
    @Test
    public void run() {
        String s = "leetcode";
        System.out.println(removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        if ("".equals(s)) {
            return s;
        }

        Set<String> set = new TreeSet<>(Arrays.asList(s.split("")));
        for (String ch : set) {
            String sub = s.substring(s.indexOf(ch));
            Set<String> suffix = new TreeSet<>(Arrays.asList(sub.split("")));
            if (suffix.equals(set)) {
                return ch + removeDuplicateLetters(sub.replaceAll(ch, ""));
            }
        }

        return "";
    }
}
