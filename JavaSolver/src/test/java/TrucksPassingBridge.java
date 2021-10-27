import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/*
bridge_length	weight	truck_weights	answer
        1	2	[1, 1, 1]	4
        1	1	[1, 1, 1]	4
        4	2	[1, 1, 1, 1]	10
        3	3	[1, 1, 1]	6
        3	1	[1, 1, 1]	10
        5	5	[1, 1, 1, 1, 1, 2, 2]	14
        7	7	[1, 1, 1, 1, 1, 3, 3]	18
        5	5	[1, 1, 1, 1, 1, 2, 2, 2, 2]	19
        5	5	[2, 2, 2, 2, 1, 1, 1, 1, 1]	19
 */
public class TrucksPassingBridge {

    @Test
    public void run() {
        System.out.println(
//                solution(2, 10, new int[] {7, 4, 5, 6})
//                solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10})
//                solution(5, 5, new int[] {2, 2, 2, 2, 1, 1, 1, 1, 1})
                solution(5, 5, new int[] {1, 1, 1, 1, 1, 2, 2, 2, 2, 2})
        );
    }

    class Truck {
        int time;
        int weight;
        Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }

    private int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0;
        int time = 0;
        Queue<Truck> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int thisWeight = truck_weights[i];
            if (weight - currentWeight >= thisWeight) {
                queue.add(new Truck(++time, thisWeight));
                currentWeight += thisWeight;
                Truck head = queue.peek();
                if (head.time + bridge_length == time) {
                    queue.poll();
                    currentWeight -= head.weight;
                }
//                System.out.println(i + " (" + thisWeight +  ", " + currentWeight +  ") : " + time);
            } else {
                while (weight - currentWeight < thisWeight && !queue.isEmpty()) {
                    Truck passed = queue.poll();
                    currentWeight -= passed.weight;
                    time = passed.time + bridge_length;
                }
                queue.add(new Truck(time, thisWeight));
                currentWeight += thisWeight;
//                System.out.println(i + " (" + thisWeight +  ", " + currentWeight +  ") : " + time);
            }
        }

        Truck last = null;
        while (!queue.isEmpty()) {
            last = queue.poll();
        }

        answer = last.time + bridge_length;

        return answer;
    }
}
