package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이얼 140ms 14276KB

public class Prob5622_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            int text = str.charAt(i);

            if (text < 68) {
                count += 3;
            } else if (text < 71) {
                count += 4;
            } else if (text < 74) {
                count += 5;
            } else if (text < 77) {
                count += 6;
            } else if (text < 80) {
                count += 7;
            } else if (text < 84) {
                count += 8;
            } else if (text < 87) {
                count += 9;
            } else if (text < 91) {
                count += 10;
            }
        }

        sb.append(count);
        System.out.println(sb);
        br.close();
    }
}