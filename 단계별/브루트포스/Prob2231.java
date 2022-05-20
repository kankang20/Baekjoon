package 단계별.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2231 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // OPTION 1 : 144ms 14476KB

        int number = Integer.parseInt(br.readLine());

        int i;
        boolean check = false;

        for (i = 1; i < number; i++) {

            int sum = i;
            int tmp = i;

            while (tmp > 0) {
                sum += (tmp % 10);
                tmp /= 10;
            }

            if (sum == number) {
                check = true;
                break;
            }
        }

        if (check) sb.append(i);
        else sb.append(0);

        System.out.println(sb);
        br.close();
    }
}
