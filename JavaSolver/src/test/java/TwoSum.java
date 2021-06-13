import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class TwoSum {
    
    @Test
    public void run() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] answer = solution(nums, target);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[] {index, i};
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
