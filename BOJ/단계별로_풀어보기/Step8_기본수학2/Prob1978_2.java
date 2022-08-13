package BOJ.단계별로_풀어보기.Step8_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 124ms 14224KB

public class Prob1978_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int count = 0;

        for (int i = 0; i < number; i++) {

            int num = Integer.parseInt(str.nextToken());

            if (num == 1) continue;

            boolean check = true;

            for (int j = 2; j < num; j++) {
                    
                if (num % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;
            }
            
        }

        sb.append(count);
        
        System.out.println(sb);
        br.close(); 
    }
}