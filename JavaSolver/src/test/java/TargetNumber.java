import org.junit.jupiter.api.Test;

/*
    입력된 숫자들로 +, - 연산을 통해 원하는 결과 값이 나오는 경우의 수를 찾는 문제.
    각 노드당 +, -의 2가지로만 갈리기 때문에 이진 트리가 생성되고 간단한 DFS로 이진 트리 순회를 하다보면 모든 경우의 수를 찾게 된다.
*/

public class TargetNumber {

    @Test
    public void run() {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
    }

    private int solution(int[] numbers, int target) {
        int answer = 0;

        answer = search(0, 0, numbers, target);

        return answer;
    }

    public int search(int index, int value, int[] numbers, int target) {
        if (index == numbers.length) {
            if (value == target) {
                // cnt++;
                return 1;
            } else {
                return 0;
            }
        } else {
            return search(index + 1, value + numbers[index], numbers, target)
                    + search(index + 1, value - numbers[index], numbers, target);
        }
    }
}
