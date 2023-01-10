package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방향전환 96ms 22068KB

public class Prob8382 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 실행 //////////////////////////////////////////////////////////////////////////

            int x = Math.abs(x1 - x2);
            int y = Math.abs(y1 - y2);

            int avg = (x + y) / 2;

            int sum = avg * 2 + Math.abs(x - avg) + Math.abs(y - avg);

            sb.append("#" + testcase + " " + sum);
            System.out.println(sb);
        }
    }
}
