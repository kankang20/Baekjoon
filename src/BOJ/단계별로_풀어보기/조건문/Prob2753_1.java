package BOJ.단계별로_풀어보기.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 윤년 128ms 14424KB

public class Prob2753_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}