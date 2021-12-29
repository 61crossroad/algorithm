import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Lp21112702 {

    @Test
    public void run() {
        int a = solution(new int[]
                {0, 1, 100, 99, 98, 97, 96}
        );
        System.out.println(a);
    }

    public int solution(int[] arr) {
        int answer = 0;
        BigInteger count = BigInteger.ZERO;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                count = count.add(BigInteger.ONE);
                for (int left = i - 1, right = i + 1, lcache = i, rcache = i; left >= 0 || right < arr.length; ) {
                    boolean flag = false;
                    if (left - 1 >= 0 && left < lcache && arr[left - 1] < arr[left]) {
                        flag = true;
                        count = count.add(BigInteger.ONE);
                    }
                    if (right + 1 < arr.length && rcache < right && arr[right] > arr[right + 1]) {
                        flag = true;
                        count = count.add(BigInteger.ONE);
                    }
                    if (left - 1 >= 0 && left < lcache && right + 1 < arr.length && rcache < right && arr[left - 1] < arr[left] && arr[right] > arr[right + 1]) {
                        count = count.add(BigInteger.ONE);
                    }
                    if (!flag) {
                        break;
                    }
                    lcache = left;
                    rcache = right;
                    if (left > 0) {
                        left--;
                    }
                    if (right < arr.length - 1) {
                        right++;
                    }
                }
            }
        }

        answer = count.remainder(new BigInteger("1000000007")).intValue();
        return answer;
    }

}
