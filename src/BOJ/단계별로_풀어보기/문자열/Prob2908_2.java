package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 상수 124ms 14252KB

public class Prob2908_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());

        int number1 = Integer.parseInt(sb1.reverse().toString());
        int number2 = Integer.parseInt(sb2.reverse().toString());

        sb.append(number1 > number2 ? number1 : number2);

        System.out.println(sb);
        br.close();
    }
}