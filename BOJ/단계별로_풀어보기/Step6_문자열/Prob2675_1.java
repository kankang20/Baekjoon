package BOJ.단계별로_풀어보기.Step6_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 124ms 14008KB

public class Prob2675_1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < repeat; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            count = Integer.parseInt(st.nextToken());
            char[] text = (st.nextToken()).toCharArray();

            for (int j = 0; j < text.length; j++) {
                for (int k = 0; k < count; k++) {
                    sb.append(text[j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
        
    } 
}