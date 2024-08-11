
/**
* title  : 42583. 다리를 지나는 트럭 (Level 2)
*/

import java.util.*;

public class Prob42583 {
    
    public static void main(String[] args) {

        int b1 = 2;
        int w1 = 10;
        int[] t1 = {7,4,5,6};
        System.out.println(solution(b1, w1, t1));

        int b2 = 100;
        int w2 = 100;
        int[] t2 = {10};
        System.out.println(solution(b2, w2, t2));

        int b3 = 100;
        int w3 = 100;
        int[] t3 = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(b3, w3, t3));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    
        Queue<Integer> q = new LinkedList<>();
        q.add(truck_weights[0]);

        int truck_count = truck_weights.length;     // 트럭 개수

        int count = 1;                              // 다리 위에 올라간 트럭의 개수 (0포함)
        int bridge_weight = truck_weights[0];       // 다리 위의 올라간 트럭의 무게

        int tdx = 1;                                // 트럭 순서
        int answer = 1;                             // 시간
        while (bridge_weight > 0 ) {

            answer += 1;

            if (count == bridge_length) {
                bridge_weight -= q.poll();
                count -= 1;
            }

            // 다리 위의 트럭 개수가 bridge_length보다 작고 트럭이 올라갔을 때 견딜 수 있는 무게라면
            if (tdx < truck_count && count < bridge_length && bridge_weight + truck_weights[tdx] <= weight) {
                bridge_weight += truck_weights[tdx];
                q.add(truck_weights[tdx]);
                tdx += 1;
            } else {
                q.add(0);
            }

            count += 1;
        }

        return answer;
    }
}
