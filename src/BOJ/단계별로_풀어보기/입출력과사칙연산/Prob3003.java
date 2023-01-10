package BOJ.단계별로_풀어보기.입출력과사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 킹, 퀸, 룩, 비숍, 나이트, 폰 
// 128ms 14316KB (java11) 80ms 11536KB (java8)

public class Prob3003 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int c = 0; c < 6; c++) {
            switch (c) {
                case 0:
                case 1:
                    sb.append(1 - Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                case 3:
                case 4:
                    sb.append(2 - Integer.parseInt(st.nextToken()));
                    break;
                case 5:
                    sb.append(8 - Integer.parseInt(st.nextToken()));
                    break;
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }

}
