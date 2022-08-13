package BOJ.단계별로_풀어보기.Step2_조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 128ms 14280KB

public class Prob1330_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer (br.readLine(), " ");

        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        if(a > b) {
            bw.write(">");
        } else if(a < b) {
            bw.write("<");
        } else {
            bw.write("==");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
