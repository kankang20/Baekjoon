package BOJ.단계별로_풀어보기.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// A+B - 8 180ms 16576KB

public class Prob11022_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write("Case #" + Integer.toString(i) + ": "
                    + Integer.toString(a) + " + "
                    + Integer.toString(b) + " = " + Integer.toString(a + b));
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}