package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 132ms 14424KB

public class Prob1008_3 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");

        double a = Double.parseDouble (st.nextToken());
        double b = Double.parseDouble (st.nextToken());

        bw.write(Double.toString(a / b));
        bw.flush();
        bw.close();

        br.close();  
    }
}
