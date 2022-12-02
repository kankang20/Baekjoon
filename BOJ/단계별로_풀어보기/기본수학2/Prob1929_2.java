package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기 328ms 24436KB

public class Prob1929_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        boolean[] check = new boolean[N + 1];

        check[0] = true;
        check[1] = true;

        for (int i = 2; i <= Math.sqrt(N + 1); i++) {

            if (check[i])
                continue;

            for (int j = i * i; j <= N; j += i) {
                check[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!check[i])
                sb.append(i + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}