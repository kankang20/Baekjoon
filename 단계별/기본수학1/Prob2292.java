package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2292 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 124ms 14344KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        int count = 0;
        int maximum = 1;

        while (maximum < number) {
            count++;
            maximum += (6 * count);
        }

        count++;

        sb.append(count);
        
        System.out.println(sb);
        br.close();
    }
}
