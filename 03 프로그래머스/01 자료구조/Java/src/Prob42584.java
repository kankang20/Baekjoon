
/**
* title  : 42584. 주식가격 (Level 2)
*/

import java.util.*;

public class Prob42584 {
    
    public static void main(String[] args) {

        int[] p1 = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(p1)));
    }

    public static int[] solution(int[] prices) {

        int length = prices.length;

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int stan = prices[i];
            int count = i;
            for (int j = i+1; j < length; j++) {
                count += 1;
                if (prices[j] < stan) break;
            }
            answer[i] = count - i;
        }

        return answer;
    }
}
