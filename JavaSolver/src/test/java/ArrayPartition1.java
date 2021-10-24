import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPartition1 {

    @Test
    public void run() {
        int answer = arrayPairSum(new int[] {6,2,6,5,1,2});
        System.out.println(answer);
    }

    public int arrayPairSum(int[] nums) {
        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < numList.size(); i += 2) {
            sum += Math.min(numList.get(i), numList.get(i + 1));
        }

        return sum;
    }

}
