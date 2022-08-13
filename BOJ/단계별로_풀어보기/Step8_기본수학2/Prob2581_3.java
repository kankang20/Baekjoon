package BOJ.단계별로_풀어보기.Step8_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 152ms 15908KB

public class Prob2581_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number1 = Integer.parseInt(br.readLine());
        int number2 = Integer.parseInt(br.readLine());

        int min = number2;
        int sum = 0;

        for (int i = number1; i <= number2; i++) {

            boolean check = true;

            if (i==1) continue;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                    
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                sum += i;

                if (i < min) {
                    min = i;
                }
            }
    }

        if (sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum + "\n" + min);
        }
        
        System.out.println(sb);
        br.close(); 
    }
}