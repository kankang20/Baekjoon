package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 120ms 14244KB

public class Prob1000_4 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String str = br.readLine();

        String[] strSplit = str.split(" ");

        int a_split = Integer.parseInt (strSplit[0]);
        int b_split = Integer.parseInt (strSplit[1]);

        System.out.println(a_split + b_split);
    }
}
