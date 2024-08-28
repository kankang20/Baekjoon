
/**
* title  : 2070. 큰 놈, 작은 놈, 같은 놈 (D1)
* time   : 101ms
* memory : 18364kb
*/

import java.io.*;
import java.util.*;
 
public class Prob2070 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            String answer = "";

            if (n1 == n2) {
                answer = "=";
            } else if (n1 < n2) {
                answer = "<";
            } else if (n1 > n2) {
                answer = ">";
            }

            sb.append("#" + t).append(" " + answer).append("\n");
        }

        System.out.println(sb);
    }
}
