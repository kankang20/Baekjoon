
/**
* title  : 7626. 연탄 배달의 시작 (Level 1)
* time   : 75ms
* memory : 10.56MB
*/

import java.io.*;
import java.util.*;

public class Prob7626 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
    
        int[] town = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[N-1];
        int min_diff = 1000000;
        for (int i = 0; i < N-1; i++) {
            diff[i] = Math.abs(town[i] - town[i+1]);
            if (diff[i] < min_diff) {
                min_diff = diff[i];
            }
        }

        int answer = 0;
        for (int i = 0; i < N-1; i++) {
            if (min_diff == diff[i]) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
