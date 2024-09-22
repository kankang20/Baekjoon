
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
                while (number < N) {
                    state[number] = Math.abs(state[number] - 1);
                    number += number;
                }
            } else {            // 여학생
                state[number] = Math.abs(state[number] - 1);

                int ln = number;
                int rn = number;
                while (0 <= --ln && ++rn < N && state[ln] == state[rn]) {
                    state[ln] = Math.abs(state[ln] - 1);
                    state[rn] = Math.abs(state[rn] - 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(state[i] + " ");
        }
    }
}
