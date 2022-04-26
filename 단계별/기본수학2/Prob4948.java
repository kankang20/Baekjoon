package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob4948 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // OPTION 1 : 960ms 14804KB

        while (true) {

            int input = Integer.parseInt(br.readLine());

            if (input==0) break;

            int count = 0;

            for (int i = input+1; i <= 2*input; i++) {
    
                boolean check = true;
    
                for (int j = 2; j <= Math.sqrt(i); j++) {
                        
                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                }
    
                if (check) {
                    count++;
                }
            }

            sb.append(count + "\n");
        }

        // OPTION 2 : 224ms 27328KB
        // '에라토스테네스의 체' 사용

        while (true) {

            int input = Integer.parseInt(br.readLine());

            if (input==0) break;

            int count = 0;

            boolean[] check = new boolean[input*2+1];

            check[0] = true;
            check[1] = true;

            for (int i = 2; i <= Math.sqrt(input*2+1); i++) {

                if (check[i]) continue;

                for (int j = i*i; j <= input*2; j += i) {
                    check[j] = true;
                }
            }

            for (int i = input+1; i <= input*2; i++) {
                if (!check[i]) count++;
            }

            sb.append(count + "\n");
        }
        
        System.out.println(sb);
        br.close(); 
    }
}
