
/**
* title  : 42587. 프로세스 (Level 2)
*/

import java.util.*;

public class Prob42587 {
    
    public static void main(String[] args) {

        int[] p1 = {2, 1, 3, 2};
        int l1 = 2;
        System.out.println(solution(p1, l1));

        int[] p2 = {1, 1, 9, 1, 1, 1};
        int l2 = 0;
        System.out.println(solution(p2, l2));
    }

    public static int solution(int[] priorities, int location) {

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            int[] temp = {i, priorities[i]};
            q.add(temp);
        }

        Integer[] priority = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(priority, Collections.reverseOrder());

        int pdx = 0;
        int answer = 0;

        while (!q.isEmpty()) {

            int[] temp = q.poll();

            if (temp[1] == priority[pdx]) {
                pdx += 1;
                answer += 1;
                if (temp[0] == location) return answer;
            }

            q.add(temp);
        }
        
        return answer;
    }
}
