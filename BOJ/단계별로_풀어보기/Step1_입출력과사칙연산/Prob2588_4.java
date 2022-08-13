package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 128ms 14164KB

public class Prob2588_4 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        int a1 = Integer.parseInt(br.readLine());    // 한 행씩 입력되는 숫자를 받아옴
        int b1 = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(a1*(b1%10)) + "\n");
        bw.write(Integer.toString(a1*(b1%100/10)) + "\n");
        bw.write(Integer.toString(a1*(b1/100)) + "\n");
        bw.write(Integer.toString(a1*b1));
        bw.flush();
        bw.close();

        br.close(); 
    }
}
