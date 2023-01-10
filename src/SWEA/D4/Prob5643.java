package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [Professional] 키 순서 1201ms 104564KB

public class Prob5643 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        final int INF = Integer.MAX_VALUE >> 3;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 /////////////////////////////////////////////////

            int N = Integer.parseInt(br.readLine()); // 학생들의 수
            int M = Integer.parseInt(br.readLine()); // 키를 비교한 횟수

            int[][] map = new int[N + 1][N + 1];

            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            // 출력 /////////////////////////////////////////////////

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j && map[i][j] == 0)
                        map[i][j] = INF;
                }
            }

            for (int k = 1; k <= N; k++) { // 경유지
                for (int i = 1; i <= N; i++) { // 출발지
                    for (int j = 1; j <= N; j++) { // 도착지
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                    }
                }
            }

            boolean check = true;
            int ans = 0;

            for (int i = 1; i <= N; i++) {
                check = true;
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == INF && map[j][i] == INF) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    ans++;
            }

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    }

}
