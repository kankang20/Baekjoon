package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 소수 구하기 376ms 27180KB

public class Prob1929_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        ArrayList<Boolean> primeList = new ArrayList<>(N + 1);

        primeList.add(false);
        primeList.add(false);

        for (int i = 2; i <= N; i++) {
            primeList.add(i, true);
        }

        for (int i = 2; (i * i) <= N; i++) {
            if (primeList.get(i)) {
                for (int j = i * i; j <= N; j += i)
                    primeList.set(j, false);
            }
        }

        for (int i = M; i <= N; i++) {
            if (primeList.get(i)) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}