
/**
* title  : 42885. 구명보트 (Level 2)
*/

import java.util.*;

public class Prob42885 {
    
    public static void main(String[] args) {

        int[] p1 = {70, 50, 80, 50};
        int l1 = 100;
        System.out.println(solution(p1, l1));

        int[] p2 = {70, 80, 50};
        int l2 = 100;
        System.out.println(solution(p2, l2));

        int[] p3 = {50};
        int l3 = 100;
        System.out.println(solution(p3, l3));
    }

    public static int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        
        int answer = 0;
        while (start <= end) {
            
            while (start <= end && people[start] + people[end] > limit) {
                answer++;
                end--;
            }
            
            if (start <= end) {
                answer++;
            }

            start++;
            end--;
        }

        return answer;
    }
}
