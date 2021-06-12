import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/* 문자열 압축 문제
1. 압축 단위 i를 1부터 n/2까지 돌린다.
2. 입력 문자열 s를 i개씩 잘라서 부분 문자열 리스트를 만든다.
3. 선택 정렬하듯이 이중루프로 비교한다.
설렁설렁 짜면 보통 70점 정도는 나올텐데, 몇가지 처리를 꼼꼼하게 해줘야 100점이 나온다.
1. 부분 문자열을 만들때, 마지막 부분 문자열이 입력 문자열을 넘으면 길이에 맞춰서 잘라줘야 한다.
2 - 1. 압축된 횟수가 많으면 그 횟수 값의 길이에 대한 처리도 해줘야 한다. (abc가  200번 반복되었으면 200abc이므로 6자리이다.)
2 - 2. 그러나 압축을 하지 않았다면 압축 횟수를 뺀 문자열 자체만 문자열로 넣어야 한다. (abc가 한 번 반복되었다면 abc만 카운트한다. 1abc가 아니다.)
4. 압축할 문자열과 부분 문자열을 비교할때도 (1)로 인해 짤린 부분 문자열 처리를 해줘야 한다.

답으로 길이만 리턴하면 되서 실제로 문자열을 만들지 않고 카운트만 했는데, 그냥 시키는대로 문자열 다 만들고 length 함수값을 리턴하는 게 예외처리도 잘 되고 좋을 것 같다. 어차피 실행 시간에 대한 제한은 널널하기 때문에...
*/

public class StringCompress {

    @Test
    public void run() {
        String input = "aaaaaaaaaa";
        System.out.println(input + " [" + input.length() + "]");
        int answer = solution(input);
        System.out.println(answer);
    }

    private int solution(String s) {
        int answer = 0;
        int length = s.length();
        answer = length;

        for (int i = 1; i <= (int)(length / 2); i++) {
            List<String> str = new ArrayList<String>();

            for (int j = 0; j < length; j += i) {
                String temp;
                if (length <= (j + i)) {
                    temp = s.substring(j, length);
                } else {
                    temp = s.substring(j, j + i);
                }
                str.add(temp);
            }

            int sum = 0;
            for (int k = 0; k < str.size(); ) {
                if ((k + 1) < str.size()) {
                    int cnt = 1;
                    int l;
                    for (l = k + 1; l < str.size(); l++) {
                        if (str.get(l).equals(str.get(k))) {
                            cnt++;
                        } else {
                            break;
                        }
                    }

                    sum += str.get(k).length();

                    String cntStr = Integer.toString(cnt);
                    if (cnt > 1) {
                        sum += cntStr.length();
                    }

                    k = l;
                } else {
                    sum += str.get(k).length();
                    k++;
                }
            }

            if (sum < answer) {
                answer = sum;
            }
        }

        return answer;
    }
}
