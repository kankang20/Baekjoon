package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이얼 132ms 14152KB

public class Prob5622_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            String text = String.valueOf(str.charAt(i));

            if ("ABC".contains(text)) {
                count += 3;
            } else if ("DEF".contains(text)) {
                count += 4;
            } else if ("GHI".contains(text)) {
                count += 5;
            } else if ("JKL".contains(text)) {
                count += 6;
            } else if ("MNO".contains(text)) {
                count += 7;
            } else if ("PQRS".contains(text)) {
                count += 8;
            } else if ("TUV".contains(text)) {
                count += 9;
            } else if ("WXYZ".contains(text)) {
                count += 10;
            }
        }

        sb.append(count);
        System.out.println(sb);
        br.close();
    }
}