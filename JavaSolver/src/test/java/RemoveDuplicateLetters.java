import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/*
Array -> List -> Set (134ms)
Array -> Set (127ms)
 */

public class RemoveDuplicateLetters {
    
    @Test
    public void run() {
        String s = "leetcode";
        System.out.println(
            // removeDuplicateLetters(s)
            removeDuplicateLettersStack(s)
            );
    }

    public String removeDuplicateLettersStack(String s) {
        Map<String, Integer> counter = new HashMap<>();
        for (String ch : s.split("")) {
            Integer count = counter.getOrDefault(ch, 0);
            counter.put(ch, ++count);
        }
        Set<String> seen = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (String ch : s.split("")) {
            counter.replace(ch, counter.get(ch) - 1);
            if (seen.contains(ch)) {
                continue;
            }

            while (!stack.empty() && ch.compareTo(stack.peek()) < 0 && counter.get(stack.peek()) > 0) {
                seen.remove(stack.pop());
            }

            stack.add(ch);
            seen.add(ch);
        }

        return stack.stream().collect(Collectors.joining());
    }

    public String removeDuplicateLetters(String s) {
        if ("".equals(s)) {
            return s;
        }

        Set<String> set = new TreeSet<>(Arrays.asList(s.split("")));
        /*
        Set<String> set = new TreeSet<>();
        Set<String> suffix = new TreeSet<>();
        for (String ch : s.split("")) {
            set.add(ch);
        }
        */

        for (String ch : set) {
            String sub = s.substring(s.indexOf(ch));
            Set<String> suffix = new TreeSet<>(Arrays.asList(sub.split("")));
            /*
            suffix.clear();
            for (String subCh : sub.split("")) {
                suffix.add(subCh);
            }
            */

            if (suffix.equals(set)) {
                return ch + removeDuplicateLetters(sub.replaceAll(ch, ""));
            }
        }

        return "";
    }
}
