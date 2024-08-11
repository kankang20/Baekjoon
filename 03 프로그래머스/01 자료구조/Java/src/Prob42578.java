
/**
* title  : 42578. 의상 (Level 2)
*/

import java.util.*;

public class Prob42578 {
    
    public static void main(String[] args) {

        String[][] c1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(c1));

        String[][] c2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(c2));
    }   

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        int answer = 1;
        for (int v : map.values()) {
            answer *= (v + 1);
        }

        return answer - 1;
    }
}
