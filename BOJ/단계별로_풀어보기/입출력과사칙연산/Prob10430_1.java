package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.util.Scanner;

// 나머지 208ms 17664KB

public class Prob10430_1 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int A1 = sc.nextInt();
        int B1 = sc.nextInt();
        int C1 = sc.nextInt();

        System.out.println((A1 + B1) % C1);
        System.out.println(((A1 % C1) + (B1 % C1)) % C1);
        System.out.println((A1 * B1) % C1);
        System.out.println(((A1 % C1) * (B1 % C1)) % C1);

        sc.close();
    }
}
