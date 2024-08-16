
/**
* title  : 11652. 카드 (Silver 4)
* time   : 316ms
* memory : 34496KB
*/

import java.io.*;
import java.util.*;

public class Prob11652 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer maxValue = 0;
        Long numValue = 0L;

        HashMap<Long, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);

            if (maxValue < numberMap.get(num)) {
                numValue = num;
                maxValue = numberMap.get(num);
            } else if (maxValue.equals(numberMap.get(num))) {
                numValue = Math.min(num, numValue);
            }
        }

        System.out.println(numValue);

        /**
        * time   : 360ms
        * memory : 33796KB
        */

        // List<Long> keySet = new ArrayList<>(numberMap.keySet());

        // keySet.sort(new Comparator<Long>() {
        //     @Override
        //     public int compare(Long o1, Long o2) {
        //         if (numberMap.get(o1).equals(numberMap.get(o2))) {
        //             return o1.compareTo(o2);
        //         }
        //         return -numberMap.get(o1).compareTo(numberMap.get(o2));
        //     }
        // });

        // System.out.println(keySet.get(0));
    }
}
