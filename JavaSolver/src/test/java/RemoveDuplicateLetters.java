import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

/*
Array -> List -> Set (134ms)
Array -> Set (127ms)
 */

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
