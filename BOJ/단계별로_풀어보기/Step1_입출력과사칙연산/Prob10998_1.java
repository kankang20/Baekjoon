package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.util.Scanner;

// 220ms 17736KB

public class Prob10998_1 {
    public static void main (String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
    
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        System.out.println(num1 * num2);

        sc.close(); 
    }
}
