
/**
* title  : 11652. 카드 (Silver 4)
* time   : 360ms
* memory : 33796KB
*/

import java.io.*;
import java.util.*;

public class Prob11652 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }

        List<Long> keySet = new ArrayList<>(numberMap.keySet());

        keySet.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (numberMap.get(o1).equals(numberMap.get(o2))) {
                    return o1.compareTo(o2);
                }
                return -numberMap.get(o1).compareTo(numberMap.get(o2));
            }
        });

        System.out.println(keySet.get(0));
    }
}
