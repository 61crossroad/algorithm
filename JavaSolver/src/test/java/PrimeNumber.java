import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// TODO?
public class PrimeNumber {

    @Test
    public void run() {
        String answer = solution(new int[] {1, 0, 0});
        System.out.println("\n" + answer);
    }

    private String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(Integer.toString(num));
        }

        list.sort((o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            String[] spl1 = o1.split("");
            String[] spl2 = o2.split("");

            for (int i = 0, j = 0; ; ) {
                int cmp = spl1[i].compareTo(spl2[j]);
                if (cmp != 0) {
                    return cmp * -1;
                }
                i++;
                j++;

                if (i == len1 && j == len2) {
                    return 0;
                } else if (i == len1) {
                    i = 0;
                } else if (j == len2) {
                    j = 0;
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
