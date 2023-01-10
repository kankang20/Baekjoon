package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 보호 필름 280ms 33436KB

public class Prob2112 {

    private static int R, C, K, ans; // 막의 개수, 셀의 개수, 기준, 약품 투입 횟수
    private static int[][] map, temp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;

            map = new int[R][C];
            temp = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j] = temp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 실행 //////////////////////////////////////////////////////////////////////////

            if (isPossible()) {
                ans = 0;
            } else {
                injection(0, 0);
            }

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    } // end main

    private static void injection(int cnt, int count) {

        if (count >= ans)
            return;

        if (cnt == R) {

            if (isPossible()) {
                ans = Math.min(ans, count);
            }

            return;
        }

        // 아무런 약품을 주입하지 않음
        injection(cnt + 1, count);

        // A 약품을 주입
        for (int i = 0; i < C; i++)
            temp[cnt][i] = 0;
        injection(cnt + 1, count + 1);

        // B 약품을 주입
        for (int i = 0; i < C; i++)
            temp[cnt][i] = 1;
        injection(cnt + 1, count + 1);

        // 다시 원래대로
        for (int i = 0; i < C; i++)
            temp[cnt][i] = map[cnt][i];
    }

    private static boolean isPossible() {

        boolean check = false;
        int previous = 0, count = 0;

        for (int c = 0; c < C; c++) {

            previous = temp[0][c];
            check = false;
            count = 1;

            for (int r = 1; r < R; r++) {

                if (previous == temp[r][c]) {
                    count++;
                } else {
                    previous = temp[r][c];
                    count = 1;
                }

                if (count == K) {
                    check = true;
                    break;
                }
            }

            if (!check)
                return false;
        }

        return true;
    } // end isPossible
}
