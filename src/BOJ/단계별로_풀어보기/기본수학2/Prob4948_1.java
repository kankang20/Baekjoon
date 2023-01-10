package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 베르트랑 공준 944ms 14772KB

public class Prob4948_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = 1;
        int count;

        while (true) {

            input = Integer.parseInt(br.readLine());

            if (input == 0)
                break;

            count = 0;

            for (int i = input + 1; i <= 2 * input; i++) {

                boolean check = true;

                for (int j = 2; j <= Math.sqrt(i); j++) {

                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    count++;
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}