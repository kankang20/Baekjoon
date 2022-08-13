package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 144ms 15940KB

public class Prob2562_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = 0, count = 0;

        for(int i = 0; i < 9; i++) {

            int num = Integer.parseInt(br.readLine());

            if (num > max) {
                max = num;
                count = i+1;
            }

        }

        sb.append(max + "\n" + count);
        
        System.out.println(sb);

        br.close();
    }
}