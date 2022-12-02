package BOJ.단계별로_풀어보기.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// OX퀴즈 148ms 15920KB

public class Prob8958_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            char[] charArray = br.readLine().toCharArray();
            int sum = 0;
            int total = 0;

            for (char j : charArray) {
                if (j == 'O') {
                    sum++;
                } else {
                    sum = 0;
                }
                total += sum;
            }

            sb.append(total + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}