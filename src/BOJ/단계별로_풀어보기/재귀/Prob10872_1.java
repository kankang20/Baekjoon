package BOJ.단계별로_풀어보기.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팩토리얼 120ms 14136KB

public class Prob10872_1 {

    public static int factorial(int number) {

        int value = 0;

        if (number == 1 || number == 0)
            return 1;
        else
            value = number * factorial(number - 1);

        return value;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(factorial(Integer.parseInt(br.readLine())));

        System.out.println(sb);
        br.close();
    }
}