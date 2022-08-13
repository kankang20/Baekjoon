package BOJ.단계별로_풀어보기.Step7_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 140ms 14316KB

public class Prob10250_2 {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            if (number % height == 0) {
                System.out.println(height*100 + (number/height));
            } else {
                System.out.println((number%height)*100 + (number/height) + 1);
            }
        }
        br.close();
    }
}