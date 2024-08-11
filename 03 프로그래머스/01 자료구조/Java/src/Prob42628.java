
/**
* title  : 42628. 이중우선순위큐 (Level 3)
*/

import java.util.*;

public class Prob42628 {
    
    public static void main(String[] args) {

        String[] o1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(o1)));

        String[] o2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(o2)));
    }

    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;
        for (String op : operations) {

            st = new StringTokenizer(op);
            String check = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            if (check.equals("I")) {
                min_q.add(number);
                max_q.add(number);
            } else {
                if (number == 1 && !max_q.isEmpty()) {              // 큐에서 최댓값을 삭제합니다.
                    min_q.remove(max_q.poll());
                } else if (number == -1 && !min_q.isEmpty()) {      // 	큐에서 최솟값을 삭제합니다.
                    max_q.remove(min_q.poll());
                }
            }
        }

        if (min_q.isEmpty()) {
            return new int[] {0, 0};
        }

        return new int[] {max_q.peek(), min_q.peek()};
    }
}
