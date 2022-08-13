package BOJ.단계별로_풀어보기.Step3_반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 128ms 14200KB

public class Prob2438_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 1; i <= num; i++) {
            
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }

            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}