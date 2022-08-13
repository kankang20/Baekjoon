package BOJ.단계별로_풀어보기.Step6_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 120ms 14152KB

public class Prob11654_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int text = br.readLine().charAt(0);
        
        sb.append(text);
        System.out.println(sb);

        br.close();
    }
}