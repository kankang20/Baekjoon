package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소인수분해 180ms 15980KB

public class Prob11653_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int division = 2;

        if (N != 1) {

            while (N > 1) {

                if (N % division == 0) {
                    sb.append(division + "\n");
                    N /= division;
                } else {
                    division++;
                }
            }

            System.out.println(sb);
        }

        br.close();
    }
}