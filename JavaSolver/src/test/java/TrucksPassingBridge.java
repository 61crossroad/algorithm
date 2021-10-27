import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

// TODO!
public class TrucksPassingBridge {

    @Test
    public void run() {
        System.out.println(
//                solution(2, 10, new int[] {7, 4, 5, 6})
//                solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10})
                solution(5, 5, new int[] {5})
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

        for (int thisWeight : truck_weights) {
            if (weight - currentWeight >= thisWeight) {
                queue.add(new Truck(++time, thisWeight));
                currentWeight += thisWeight;
            } else {
                while (weight - currentWeight < thisWeight && !queue.isEmpty()) {
                    Truck passed = queue.poll();
                    currentWeight -= passed.weight;
                    time = passed.time + bridge_length;
                }
                queue.add(new Truck(time, thisWeight));
                currentWeight += thisWeight;
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
