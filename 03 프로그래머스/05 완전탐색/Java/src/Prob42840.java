
/**
* title  : 42840. 모의고사 (Level 1)
*/

import java.util.*;

public class Prob42840 {
    
    public static void main(String[] args) {

        int[] a1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(a1)));

        int[] a2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(a2)));
    }

    public static int[] solution(int[] answers) {

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] total_sum = new int[3];

        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == s1[i%5]) {
                total_sum[0] += 1;
            }

            if (answers[i] == s2[i%8]) {
                total_sum[1] += 1;
            }

            if (answers[i] == s3[i%10]) {
                total_sum[2] += 1;
            }
        }

        int max_sum = Math.max(total_sum[0], Math.max(total_sum[1], total_sum[2]));

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (total_sum[i] == max_sum) {
                answer.add(i+1);
            }
        }

        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
