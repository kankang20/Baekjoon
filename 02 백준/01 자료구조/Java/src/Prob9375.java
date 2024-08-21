
/**
* title  : 9375. 패션왕 신해빈 (Silver 3)
* time   : 104ms
* memory : 	14244KB
*/

import java.io.*;
import java.util.*;

public class Prob9375 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> countMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                String[] temp = br.readLine().split(" ");;
                countMap.put(temp[1], countMap.getOrDefault(temp[1], 0) + 1);
            }

            int answer = 1;
            for (String key : countMap.keySet()) {
                answer *= (countMap.get(key) + 1);
            }

            System.out.println(answer - 1);
        }
    }
}