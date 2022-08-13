package BOJ.단계별로_풀어보기.Step1_입출력과사칙연산;

import java.util.Scanner;

// 220ms 17624KB

public class Prob2588_1 {
    public static void main (String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
    
        int num1  = sc.nextInt();
        int num2  = sc.nextInt();

        int one = num2 % 10;
        int two = (num2-one) % 100;
        int three = num2-one-two;

        System.out.println(num1*one);
        System.out.println(num1*(two/10));
        System.out.println(num1*(three/100));
        System.out.println(num1*num2);

        sc.close();
    }
}
