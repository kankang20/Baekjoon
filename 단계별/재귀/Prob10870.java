package 단계별.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10870 {

    public static int fibonacci (int number) {

        int value = 0;

        if (number == 0) return 0;
        else if (number == 1) return 1;
        else value = fibonacci(number-1) + fibonacci(number-2);

        return value;
    }

    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 120ms 14100KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(fibonacci(Integer.parseInt(br.readLine())));

        System.out.println(sb);
        br.close(); 
    }
}
