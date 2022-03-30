package 단계별.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob8393 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 124ms 14248KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int sum = 0;

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        bw.write(Integer.toString(sum));
        bw.flush();

        bw.close();
        br.close();
    }
}
