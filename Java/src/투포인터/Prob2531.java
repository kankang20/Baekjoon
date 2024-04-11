package 투포인터;

import java.util.*;
import java.io.*;

public class Prob2531 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] selected = new int[D+1];

        selected[C] += 1;
        int answer = 1;

        for (int i = 0; i < K; i++) {
            if (selected[belt[i]] == 0) {
                answer += 1;
            }
            selected[belt[i]] += 1;
        }

        int start = 1;
        int end = K;
        int count = answer;
        while (start < N && answer < D) {

            selected[belt[start-1]] -= 1;
            if (selected[belt[start-1]] == 0) {
                count -= 1;
            }

            selected[belt[end % N]] += 1;
            if (selected[belt[end % N]] == 1) {
                count += 1;
            }

            answer = Math.max(answer, count);

            start += 1;
            end += 1;
        }

        System.out.println(answer);
    }
}