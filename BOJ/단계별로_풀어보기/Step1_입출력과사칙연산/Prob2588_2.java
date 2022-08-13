package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 124ms 14140KB

public class Prob2588_2 {
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int a1 = Integer.parseInt(br.readLine());    // 한 행씩 입력되는 숫자를 받아옴
        int b1 = Integer.parseInt(br.readLine());

        System.out.println(a1*(b1%10));
        System.out.println(a1*(b1%100/10));
        System.out.println(a1*(b1/100));
        System.out.println(a1*b1);
    }
}
