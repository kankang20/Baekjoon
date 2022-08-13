package BOJ.단계별로_풀어보기.Step7_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 120ms 14164KB

public class Prob1712_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long count = 0;;

        if (b >= c) {
            count = -1;
        } else {
            count = (a / (c - b)) + 1;        
        }

        sb.append(count);
        
        System.out.println(sb);
        br.close();
    }
}