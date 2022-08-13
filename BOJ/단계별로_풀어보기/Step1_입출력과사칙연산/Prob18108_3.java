package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 136ms 14252KB

public class Prob18108_3 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        String str = br.readLine();

        int a = Integer.parseInt(str);

        bw.write(Integer.toString(a - 543));
        bw.flush();
        bw.close();

        br.close(); 
    }
}
