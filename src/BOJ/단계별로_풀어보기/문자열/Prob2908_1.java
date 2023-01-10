package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 상수 120ms 14164KB

public class Prob2908_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        int number1 = 0;
        int number2 = 0;

        int i = 2;

        while (i >= 0) {
            number1 += (num1.charAt(i) - '0') * Math.pow(10, i);
            number2 += (num2.charAt(i) - '0') * Math.pow(10, i);
            i--;
        }

        sb.append(number1 > number2 ? number1 : number2);

        System.out.println(sb);
        br.close();
    }
}