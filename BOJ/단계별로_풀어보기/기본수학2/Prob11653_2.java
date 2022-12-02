package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소인수분해 128ms 14344KB

public class Prob11653_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(N); i++) {

            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        if (N != 1)
            sb.append(N);

        System.out.println(sb);
        br.close();
    }
}