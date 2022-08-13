package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 128ms 14316KB

public class Prob10430_3 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");
        
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString((A2+B2)%C2));
        bw.newLine();
        bw.write(Integer.toString(((A2%C2)+(B2%C2))%C2));
        bw.newLine();
        bw.write(Integer.toString((A2*B2)%C2));
        bw.newLine();
        bw.write(Integer.toString(((A2%C2)*(B2%C2))%C2));
        bw.flush();
        bw.close();

        br.close(); 
    }
}
