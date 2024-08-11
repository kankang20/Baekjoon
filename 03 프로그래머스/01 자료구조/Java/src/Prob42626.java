
/**
* title  : 42626. 더 맵게 (Level 2)
*/

import java.util.*;

public class Prob42626 {
    
    public static void main(String[] args) {

        int[] s1 = {1, 2, 3, 9, 10, 12};
        int k1 = 7;
        System.out.println(solution(s1, k1));

        int[] s2 = {1, 2, 3, 9, 10, 12};
        int k2 = 5000;
        System.out.println(solution(s2, k2));
    }

    public static int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int sc : scoville) {
            q.add(sc);
        }

        int length = scoville.length;
        int answer = 0;
        while (length > 1) {

            if (K <= q.peek()) return answer;

            q.add(q.poll() + q.poll() * 2);
            answer += 1;
            length -= 1;
        }
        
        if (K <= q.peek()) {
            return answer;
        } else {
            return -1;
        }
    }
}
