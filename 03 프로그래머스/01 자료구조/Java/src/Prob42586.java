
/**
* title  : 42586. 기능개발 (Level 2)
*/

import java.util.*;

public class Prob42586 {
    
    public static void main(String[] args) {

        int[] p1 = {93, 30, 55};
        int[] s1 = {1, 30, 5};
        System.out.println(Arrays.toString(solution(p1, s1)));

        int[] p2 = {95, 90, 99, 99, 80, 99};
        int[] s2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(p2, s2)));

        int[] p3 = {1, 1, 1, 1};
        int[] s3 = {100, 50, 99, 100};
        System.out.println(Arrays.toString(solution(p3, s3)));

        int[] p4 = {95, 94, 93};
        int[] s4 = {3, 3, 3};
        System.out.println(Arrays.toString(solution(p4, s4)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();

        int stan = (int) Math.ceil((100 - progresses[0]) / (float) speeds[0]);
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {

            int day = (int) Math.ceil((100 - progresses[i]) / (float) speeds[i]);

            if (stan < day) {
                answer.add(count);
                stan = day;
                count = 1;
            } else {
                count += 1;
                stan = Math.max(stan, day);
            }
        }

        answer.add(count);

        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
