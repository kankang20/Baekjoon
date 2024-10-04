
/**
* title  : 11728. 배열 합치기 (Silver 5)
* time   : 1208ms
* memory : 308284KB
*/

import java.io.*;
import java.util.*;
 
public class Prob11728 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int aPos = 0;
        int bPos = 0;

        int[] answer = new int[N+M];
        int pos = 0;

        while (aPos < N && bPos < M) {

            if (A[aPos] < B[bPos]) {
                answer[pos] = A[aPos];
                pos++;
                aPos++;
            } else {
                answer[pos] = B[bPos];
                pos++;
                bPos++;
            }
        }

        if (aPos < N) {
            for (int i = aPos; i < N; i++) {
                answer[pos] = A[i];
                pos++;
            }
        } else {
            for (int i = bPos; i < M; i++) {
                answer[pos] = B[i];
                pos++;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}
