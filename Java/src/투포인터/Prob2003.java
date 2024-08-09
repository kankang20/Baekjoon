package 투포인터;

import java.util.*;
import java.io.*;

public class Prob2003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(N, M, number));
    }

    public static int search(int N, int M, int[] number) {

        int answer = 0;
        int sum = 0;

        int start = 0;
        int end = 0;
        
        while (start < N) {

            if (M <= sum) {
                sum -= number[start++];
            } else if (end == N) {
                return answer;
            } else if (sum < M) {
                sum += number[end++];
            }

            if (sum == M) {
                answer++;
            }
        }

        return answer;
    }
}