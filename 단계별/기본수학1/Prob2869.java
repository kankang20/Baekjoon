package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2869 {
    public static void main(String[] args) throws IOException {
       
        // 시간초과
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int count = 0;

        while (true) {
            count++;
            v -= a;
            if (v<=0) break;
            v += b;
        }

        sb.append(count);

        System.out.println(sb);
        br.close();
    }
}
