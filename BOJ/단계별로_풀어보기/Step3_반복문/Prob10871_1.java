package BOJ.단계별로_풀어보기.Step3_반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 212ms 15732KB

public class Prob10871_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        int count = Integer.parseInt(st.nextToken());
        int standard = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer numbers = new StringTokenizer (br.readLine(), " ");

        for (int i = 0; i < count; i++) {
            
            String num = numbers.nextToken();

            if (Integer.parseInt(num) < standard) {
                bw.write(num + " ");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}