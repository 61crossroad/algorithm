import java.util.Stack;

import org.junit.jupiter.api.Test;

public class TrappingRainWater {

    @Test
    public void run() {
        int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    private int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();

                if (stack.empty()) {
                    break;
                }

                int depth = Math.min(height[i], height[stack.peek()]) - height[bottom];
                int distance = i - stack.peek() - 1;
                volume += depth * distance;
            }

            stack.add(i);
        }

        return volume;
    }
}
