import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class ProductOfArrayExceptSelf {

    @Test
    public void run() {
        int[] answer = productExceptSelf(new int[] {
                1,2,3,4
        });

        Stream.of(answer).forEach(n -> System.out.print(Arrays.toString(n) + " "));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sumLeft[i] = i == 0 ? nums[i] : nums[i] * sumLeft[i - 1];
            sumRight[n - 1 - i] = i == 0 ? nums[n - 1 - i] : nums[n - 1 - i] * sumRight[n - i];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 1 : sumLeft[i - 1];
            int right = i == n - 1 ? 1 : sumRight[i + 1];
            answer[i] = left * right;
        }

        return answer;
    }

}
