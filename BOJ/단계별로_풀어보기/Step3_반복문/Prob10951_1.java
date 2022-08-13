package BOJ.단계별로_풀어보기.Step3_반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 120ms 14092KB

public class Prob10951_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        
        String input = "";

        while ((input = br.readLine()) != null) {
            
            StringTokenizer st = new StringTokenizer (input, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(a+b));
            bw.newLine();
        }
        
        bw.flush();

        bw.close();
        br.close();
    }
}