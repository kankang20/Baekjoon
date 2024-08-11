
/**
* title  : 42576. 완주하지 못한 선수 (Level 1)
*/

import java.util.*;

public class Prob42576 {

    public static void main(String[] args) {

        String[] p1 = {"leo", "kiki", "eden"};
        String[] c1 = {"eden", "kiki"};
        System.out.println(solution(p1, c1));

        String[] p2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] c2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(p2, c2));

        String[] p3 = {"mislav", "stanko", "mislav", "ana"};
        String[] c3 = {"stanko", "ana", "mislav"};
        System.out.println(solution(p3, c3));

    }

    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.replace(c, map.get(c) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() > 0) {
                return entry.getKey().toString();
            }
        }

        return null;
    }
    
}
