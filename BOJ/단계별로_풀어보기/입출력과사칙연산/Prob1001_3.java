package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.util.Scanner;

// A-B 208ms 17712KB

public class Prob1001_3 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1 - num2);

        sc.close();
    }
}
