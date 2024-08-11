
/**
* title  : 42842. 카펫 (Level 2)
*/

import java.util.*;

public class Prob42842 {
    
    public static void main(String[] args) {

        int b1 = 10;
        int y1 = 2;
        System.out.println(Arrays.toString(solution(b1, y1)));

        int b2 = 8;
        int y2 = 1;
        System.out.println(Arrays.toString(solution(b2, y2)));

        int b3 = 24;
        int y3 = 24;
        System.out.println(Arrays.toString(solution(b3, y3)));
    }
    
    public static int[] solution(int brown, int yellow) {

        // 노란색의 개수 = (가로 - 2) * (세로 - 2)
        // 갈색의 개수 = 가로 * 2 + (세로 - 2) * 2 = (가로 + 세로 - 2) * 2

        int sum = (brown / 2) + 2;

        for (int width = (int) Math.ceil(sum/2.0); width < sum; width++) {

            int height = sum - width;

            if ((width - 2) * (height - 2) == yellow) {
                return new int[] {width, height};
            }
        }

        return new int[] {0, 0};
    }
}
