import org.junit.jupiter.api.Test;

import java.util.*;

public class FindPrimeNumbers {
    private Map<Integer, Integer> primes = new HashMap<>();
    private Map<Integer, Integer> checked = new HashMap<>();
    private Map<Integer, Integer> visited = new HashMap<>();
    private int cnt = 0;

    @Test
    public void run() {
        System.out.println(" -> " +
                solution("011"));
    }

    private int solution(String numbers) {
        int answer = 0;

        String[] sp = numbers.split("");
        List<Integer> nums = new ArrayList<>();
        for (String s : sp) {
            nums.add(Integer.parseInt(s));
        }

        make(0, nums);
        // answer = cnt;

        Iterator<Integer> it = checked.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            if (checked.get(key) == 1) {
                answer++;
            }
        }

        return answer;
    }

    private void make(int n, List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            int next = n * 10 + nums.get(i);
            if (/* checked.getOrDefault(next, 0) < 1 && */ visited.getOrDefault(i, 0) < 1) {
                visited.put(i, 1);
                // make(n * 10 + nums.get(i), nums);
                make(next, nums);
                visited.put(i, 0);
            }
        }

        if (1 < n && checked.getOrDefault(n, 0) != 1) {
            int isPrime = primes.computeIfAbsent(n, v -> {
                for (int i = 2; i <= Math.sqrt(v); i++) {
                    if (v % i == 0) {
                        return 0;
                    }
                }
                return 1;
            });

            if (0 < isPrime) {
                checked.put(n, 1);
                cnt++;
            }
        }
    }
}
