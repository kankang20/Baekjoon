package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// A+B 128ms 14220KB

public class Prob1000_3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");

        int a_token = Integer.parseInt(st.nextToken());
        int b_token = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(a_token + b_token));
        bw.flush();
        bw.close();

        br.close();
    }
}
