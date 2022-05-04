package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9020 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int num = Integer.parseInt(br.readLine());

            boolean[] check = new boolean[num+1];

            check[0] = true;
            check[1] = true;

            for (int j = 2; j <= Math.sqrt(num+1); j++) {

                if (check[j]) continue;

                for (int k = j*j; k <= num; k += j) {
                    check[k] = true;
                }
            }

            int diff = 100;
            int number1 = 0, number2 = 0;

            for (int j = 2; j <= num/2; j++) {

                if (!check[j] && !check[num - j]) {
                    if (num - 2*j < diff) {
                        diff = num - 2*j;
                        number1 = j;
                        number2 = num - j;
                    }
                }
            }

            sb.append(number1 + " " + number2 + "\n");
        }
        
        System.out.println(sb);
        br.close(); 
    }
}
