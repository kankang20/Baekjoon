package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 132ms 14244KB

public class Prob1001_1 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");

        int a = Integer.parseInt (st.nextToken());
        int b = Integer.parseInt (st.nextToken());

        bw.write(Integer.toString(a - b));
        bw.flush();
        bw.close();

        br.close(); 
    }
}
