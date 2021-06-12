import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchRecursive {

    @Test
    public void run() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 15, 17, 20);
        int sol = location(0, list.size(), 11, list);
        System.out.println("sol = " + sol);
    }

    private int location(int low, int high, int x, List<Integer> list) {
        int mid;

        if (low > high) {
            return 0;
        } else {
            mid = (int) Math.floor((low + high) / 2);

            if (list.get(mid) == x) {
                return mid;
            } else if (x < list.get(mid)) {
                return location(low, mid - 1, x, list);
            } else {
                return location(mid + 1, high, x, list);
            }
        }
    }
}
