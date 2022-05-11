package 단계별.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10872 {

    public static int factorial (int number) {

        int value = 0;

        if (number == 1 || number == 0) return 1;
        else value = number * factorial(number-1);

        return value;
    }

    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 120ms 14136KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(factorial(Integer.parseInt(br.readLine())));

        System.out.println(sb);
        br.close(); 
    }
}