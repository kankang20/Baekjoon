package BOJ.단계별로_풀어보기.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 알람 시계 136ms 14492KB

public class Prob2884_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == 0) {
            a = 24;
        }

        int sum = (60 * a + b) - 45;

        int hour = sum / 60;
        int minute = sum % 60;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (hour == 24) {
            hour = 0;
        }

        bw.write(Integer.toString(hour) + " ");
        bw.write(Integer.toString(minute));

        bw.flush();
        bw.close();

        br.close();

    }
}
