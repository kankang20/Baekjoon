package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 132ms 14272KB

public class Prob18108_2 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        int a = Integer.parseInt(str);

        System.out.println(a - 543);
    }
}
