package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 반복 124ms 14112KB

public class Prob2675_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int count = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            for (int j = 0; j < text.length(); j++) {
                for (int k = 0; k < count; k++) {
                    sb.append(text.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}