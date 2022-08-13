package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 124ms 14120KB

public class Prob2588_5 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        int a2 = Integer.parseInt(br.readLine());    // 한 행씩 입력되는 숫자를 받아옴
        String b2 = br.readLine();

        bw.write(Integer.toString(a2 * (b2.charAt(2)-'0')));    // -'0'을 통해 아스키코트를 숫자로
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2.charAt(1)-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2.charAt(0)-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * Integer.parseInt(b2)));
        bw.flush();
        bw.close();

        br.close(); 
    }
}
