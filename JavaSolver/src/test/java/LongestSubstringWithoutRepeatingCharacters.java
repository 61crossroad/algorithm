import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
06/17/2021 01:04	Accepted	248 ms	39.7 MB	java
 - Set에 현재 포함된 문자들을 넣어두고 확인, 중복 문자가 발생하면 Set.clear() 이후 갱신한 start(=used.get(cur) + 1) ~ i까지 Set에 다시 삽입

06/17/2021 01:06	Accepted	128 ms	39.9 MB	java
 - Set에 현재 포함된 문자들을 넣어두지만 중복 문자가 나타나면 갱신전 start ~ used.get(cur)까지 삭제

06/17/2021 01:14	Accepted	6 ms	39.4 MB	java
 - Set을 아예 사용하지 않음. 대신 start <= used.get(cur) 조건으로 예외 처리
 */

public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void run() {
        String input =
//                "pwwkew";
//                "abcabcbb";
//                "bbbbb";
//                "";
                "abba";
        System.out.println(lengthOfLongestSubstring(input));
    }

    private int lengthOfLongestSubstring(String s) {
        Map<String, Integer> used = new HashMap<>();
        int start = 0;
        int length = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);

            Integer curIndex = used.get(cur);
            if (curIndex != null && start <= curIndex) {
                start = curIndex + 1;
                length = i - start + 1;
            } else {
                length++;
            }

            used.put(cur, i);

            if (length > max) {
                max = length;
            }
        }

        return max;
    }
}
