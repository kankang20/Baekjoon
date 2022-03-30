package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1712 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 120ms 14164KB
        
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
