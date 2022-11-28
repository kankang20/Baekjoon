package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 곱셈 128ms 14156KB

public class Prob2588_6 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a2 = Integer.parseInt(br.readLine()); // 한 행씩 입력되는 숫자를 받아옴
        String b2 = br.readLine();
        char[] b2_char = b2.toCharArray();

        bw.write(Integer.toString(a2 * (b2_char[2] - '0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2_char[1] - '0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2_char[0] - '0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * Integer.parseInt(b2)));
        bw.flush();
        bw.close();

        br.close();
    }
}
