package BOJ.단계별로_풀어보기.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분수찾기 160ms 16056KB

public class Prob1193_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int cross_count = 1;
        int previous_count = 0;

        while (true) {

            if (cross_count + previous_count >= num) {

                if (cross_count % 2 == 0) {
                    sb.append((num - previous_count) + "/" + (cross_count - (num - previous_count - 1)));
                } else {
                    sb.append((cross_count - (num - previous_count - 1)) + "/" + (num - previous_count));
                }
                break;
            }

            previous_count += cross_count;
            cross_count += 1;
        }

        System.out.println(sb);
        br.close();
    }
}