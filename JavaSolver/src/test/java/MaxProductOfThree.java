import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MaxProductOfThree {

    @Test
    public void run() {
        System.out.println(solution(
                new int[] {-3, 1, 2, -2, 5, 6}));
    }

    private int solution(int[] A) {
        Arrays.sort(A);
        int posProduct = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int negProduct = A[0] * A[1] * A[A.length - 1];

        if (posProduct > negProduct) {
            return posProduct;
        } else {
            return negProduct;
        }
    }
}
