package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 508ms 88312KB

public class Prob10818_3  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int min = 1000000, max = -1000000;

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        for(int i = 0; i < count; i++) {

            int num = Integer.parseInt(st.nextToken());

            if (num > max){
                max = num;
            }

            if (num < min) {
                min = num;
            }

        }

        sb.append(min + " " + max);
        
        System.out.println(sb);

        br.close();
    }
}