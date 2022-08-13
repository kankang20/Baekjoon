package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 128ms 14252KB

public class Prob1001_2 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");

        int a = Integer.parseInt (st.nextToken());
        int b = Integer.parseInt (st.nextToken());

        System.out.println(a - b);
    }
}
