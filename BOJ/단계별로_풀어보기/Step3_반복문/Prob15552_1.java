package BOJ.단계별로_풀어보기.Step3_반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 852ms 238432KB

public class Prob15552_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
    
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 0; i < num; i++) {
            
            StringTokenizer st = new StringTokenizer (br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString(a+b));
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
