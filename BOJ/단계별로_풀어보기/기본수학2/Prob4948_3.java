package BOJ.단계별로_풀어보기.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 베르트랑 공준 224ms 27328KB

public class Prob4948_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            int input = Integer.parseInt(br.readLine());

            if (input == 0)
                break;

            int count = 0;

            boolean[] check = new boolean[input * 2 + 1];

            check[0] = true;
            check[1] = true;

            for (int i = 2; i <= Math.sqrt(input * 2 + 1); i++) {

                if (check[i])
                    continue;

                for (int j = i * i; j <= input * 2; j += i) {
                    check[j] = true;
                }
            }

            for (int i = input + 1; i <= input * 2; i++) {
                if (!check[i])
                    count++;
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}