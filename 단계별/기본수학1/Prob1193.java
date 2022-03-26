package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1193 {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int i = num;          
        int count = 0;      // 대각선 칸 개수   // 분자와 분수의 합은 count+1
        int sum = 0;

        while (true) {

            count++;
            i -= count;
            sum += count;
            
            if (i <= 0) {
                
                // if (count % 2 == 0) {
                //     count++;
                    

                // } else {
                //     count++;
                // } break;
            
                break;
            }
        }

        sb.append(count + " " + sum);
        
        System.out.println(sb);
        br.close();
    }
}
