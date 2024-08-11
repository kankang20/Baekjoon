
/**
* title  : 43165. 타겟 넘버 (Level 2)
*/

import java.util.*;

public class Prob43165 {
    
    public static void main(String[] args) {

        int[] n1 = {1, 1, 1, 1, 1};
        int t1 = 3;
        System.out.println(solution(n1, t1));

        int[] n2 = {4, 1, 2, 1};
        int t2 = 4;
        System.out.println(solution(n2, t2));

    }

    public static int solution(int[] numbers, int target) {

        Queue<Integer> q = new LinkedList<>();

        q.add(-numbers[0]);
        q.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                int num = q.poll();
                q.add(num - numbers[i]);
                q.add(num + numbers[i]);
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            if (target == q.poll()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
