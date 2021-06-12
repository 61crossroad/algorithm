import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    문자열을 사전순 오름차순으로 정렬
    가장 짧은 문자열의 길이를 최소 length로 잡는다.
    각 문자열이 다른 문자열에 포함되는지 Map과 비교하며 확인한다.
    - 포함되면 false 리턴
    - 포함되지 않으면 Map에 해당 문자열을 넣고 루프를 계속 진행한다.
*/

public class PhoneBook {

    @Test
    public void run() {
        boolean answer = solution(
                new String[] {"119", "97674223", "1195524421"}
        );

        if (answer) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        int minLen = phone_book[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length && answer; i++) {
            String pb = phone_book[i];
            for (int j = 1; j <= minLen && answer; j++) {
                for (int k = 0; k <= pb.length() - j && answer; k++) {
                    String sub = pb.substring(k, k + j);
                    if (map.get(sub) != null) {
                        answer = false;
                    }
                }
            }

            map.put(pb, 1);
        }

        return answer;
    }
}
