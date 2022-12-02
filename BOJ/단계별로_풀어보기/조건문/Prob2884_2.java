package BOJ.단계별로_풀어보기.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 알람 시계 140ms 14300KB

public class Prob2884_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == 0) {
            if (b >= 45) {
                b -= 45;
            } else {
                a = 23;
                b += 15;
            }
        } else {
            if (b >= 45) {
                b -= 45;
            } else {
                a -= 1;
                b += 15;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(a) + " ");
        bw.write(Integer.toString(b));

        bw.flush();
        bw.close();

        br.close();

    }
}
