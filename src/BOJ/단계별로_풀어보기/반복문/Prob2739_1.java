package BOJ.단계별로_풀어보기.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 구구단 160ms 16368KB

public class Prob2739_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int number = Integer.parseInt(num);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < 10; i++) {

            bw.write(num + " * " + Integer.toString(i) + " = " + Integer.toString(number * i));
            bw.newLine();
        }

        bw.flush();
        bw.close();

        br.close();
    }
}
