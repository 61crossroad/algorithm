import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    프로그래머스 > 정렬 > 가장 큰 수
    문제 입력에서 정수 리스트가 주어지지만 문제 조건을 따르면 사전순 정렬을 하도록 요구하고 있다.
    그러므로 정수를 모두 String으로 변환해서 비교를 한다.
    다만 비교하는 문자열들에서 부분문자열이 생길 경우를 처리해줘야 한다.
    53 vs 53530 / 53 vs 53535

    일반 사전순이라면 53 < 53530 / 53 < 53535로 판단하겠지만
    53 > 53530 / 53 < 53535
    가 되어야 한다.
    그래서 짧은 문자열을 기준으로 긴 문자열을 계속 잘라가면서 재귀호출로 비교를 했는데 런타임 에러가 나왔다.
    결국 for를 돌려서 해결하긴 했으나, 좋은 해결법을 보니 그냥 53 + 53530 과 53530 + 53을 비교했다.
    사전식 정렬에서 사고가 좁아져버렸다.
*/

public class PrimeNumberSort {

    @Test
    public void run() {
        String answer = solution(new int[] {1, 0, 0});
        System.out.println("\n" + answer);
    }

    private static String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(Integer.toString(num));
        }

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length(); int len2 = o2.length();
                String[] spl1 = o1.split(""); String[] spl2 = o2.split("");

                for (int i = 0, j = 0; ; ) {
                    int cmp = spl1[i].compareTo(spl2[j]);
                    if (cmp != 0) {
                        return cmp * -1;
                    }
                    i++; j++;

                    if (i == len1 && j == len2) {
                        return 0;
                    } else if (i == len1) {
                        i = 0;
                    } else if (j == len2) {
                        j = 0;
                    }
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (String num : list) {
            if (Integer.parseInt(num) != 0) zero = false;
            sb.append(num);
        }

        answer = zero ? "0" : sb.toString();
        return answer;
    }
}
