package BOJ.단계별로_풀어보기.Step2_조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 132ms 14216KB

public class Prob2480_4 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = 0;

        if ((a==b)&&(b==c)) {
            sum = 10000 + a*1000;
        } else if ((a==b)||(a==c)) {
            sum = 1000 + a*100;
        } else if (b==c) {
            sum = 1000 + b * 100;
        } else {
            sum = Math.max(Math.max(a, b), c) * 100;
        }

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();

        br.close();

    }
}
