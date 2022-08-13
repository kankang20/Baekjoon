package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 132ms 14188KB

public class Prob1000_2 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");

        int a_token = Integer.parseInt (st.nextToken());
        int b_token = Integer.parseInt (st.nextToken());

        System.out.println(a_token + b_token);
    }
}
