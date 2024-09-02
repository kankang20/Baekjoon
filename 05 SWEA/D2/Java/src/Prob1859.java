
/**
* title  : 1859. 백만 장자 프로젝트 (D2)
* time   : 493ms
* memory : 136140kb
*/

import java.io.*;
import java.util.*;
 
public class Prob1859 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int day = Integer.parseInt(br.readLine());
            int[] price = new int[day];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < day; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0L;
            int maxPrice = price[day-1];
            for (int i = day-1; i >= 0; i--) {
                
                if (price[i] < maxPrice) {
                    answer += (maxPrice - price[i]);
                } else {
                    maxPrice = price[i];
                }
            }

            sb.append("#" + t + " ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
