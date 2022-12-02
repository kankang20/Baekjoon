package BOJ.단계별로_풀어보기.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소, 최대 504ms 88016KB

public class Prob10818_4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.parseInt(st.nextToken()), max = min;

        for (int i = 1; i < count; i++) {

            int num = Integer.parseInt(st.nextToken());

            max = Math.max(max, num);
            min = Math.min(min, num);

        }

        sb.append(min + " " + max);

        System.out.println(sb);

        br.close();
    }
}