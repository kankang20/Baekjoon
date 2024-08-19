
/**
* title  : 2910. 빈도 정렬 (Silver 3)
* time   : 108ms
* memory : 14532KB
*/

import java.io.*;
import java.util.*;

public class Prob2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> posMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!posMap.containsKey(num)) {
                posMap.put(num, i);
            }
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(countMap.keySet());
        
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (countMap.get(o1).equals(countMap.get(o2))) {
                    return posMap.get(o1).compareTo(posMap.get(o2));
                }
                return countMap.get(o2).compareTo(countMap.get(o1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keySet.size(); i++) {
            int num = keySet.get(i);
            for (int j = 0; j < countMap.get(num); j++) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}