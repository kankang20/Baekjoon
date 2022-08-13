package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.util.Scanner;

// 228ms 18032KB

public class Prob1008_1 {
    public static void main (String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
    
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        
        System.out.println(num1 / num2);

        sc.close(); 
    }
}
