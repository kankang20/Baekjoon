
/**
* title  : 1244. 스위치 켜고 끄기 (Silver 4)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob1244 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] state = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {

            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {  // 남학생

                int pos = number;
                while (pos < N) {
                    state[pos] = Math.abs(state[pos] - 1);
                    pos += number;
                }
            } else {            // 여학생
                state[number] = Math.abs(state[number] - 1);

                int lpos = number;
                int rpos = number;
                while (0 <= --lpos && ++rpos < N && state[lpos] == state[rpos]) {
                    state[lpos] = Math.abs(state[lpos] - 1);
                    state[rpos] = Math.abs(state[rpos] - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i % 20 == 0) {
                sb.append(state[i]).append("\n");        
            } else {
                sb.append(state[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
