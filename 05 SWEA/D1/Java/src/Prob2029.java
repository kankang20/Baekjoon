
/**
* title  : 2029. 몫과 나머지 출력하기 (D1)
* time   : 104ms
* memory : 18604kb
*/

import java.io.*;
import java.util.*;
 
public class Prob2029 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("#" + t + " ")
                .append(a / b).append(" ")
                .append(a % b).append("\n");
        }

        System.out.println(sb);
    }
}
