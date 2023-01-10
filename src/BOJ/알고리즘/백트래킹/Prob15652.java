package BOJ.알고리즘.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (4) 200ms 19832KB (java11) 112ms 19956KB (java8)
// 백트래킹

public class Prob15652 {

    private static StringBuilder sb = new StringBuilder();

    private static int N, M, numbers[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        permutation(0, 1);

        System.out.println(sb);
    }

    private static void permutation(int cnt, int start) {

        if (cnt == M) {
            for (int i : numbers) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            permutation(cnt + 1, i);
        }
    }
}
