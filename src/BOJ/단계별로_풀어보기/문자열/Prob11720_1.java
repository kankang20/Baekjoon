package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자의 합 124ms 14264KB

public class Prob11720_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;

        for (int i = 0; i < num; i++) {
            sum += str.charAt(i) - '0';
        }

        sb.append(sum);
        System.out.println(sb);

        br.close();
    }
}