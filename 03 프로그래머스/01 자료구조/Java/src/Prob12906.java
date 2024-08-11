
/**
* title  : 12906. 같은 숫자는 싫어 (Level 1)
*/

import java.util.*;

public class Prob12906 {
    
    public static void main(String[] args) {

        int[] a1 = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(a1)));

        int[] a2 = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution(a2)));
    }

    public static int[] solution(int []arr) {
        
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        int number = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (number != arr[i]) {
                answer.add(arr[i]);
                number = arr[i];
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
