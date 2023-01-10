package BOJ.단계별로_풀어보기.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ACM 호텔 136ms 14368KB

public class Prob10250_4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            int x = number / height;
            int y = number % height;

            if (y == 0) {
                y = height;
            } else {
                x++;
            }

            System.out.println(y * 100 + x);
        }
        br.close();
    }
}