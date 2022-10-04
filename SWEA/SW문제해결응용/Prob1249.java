package SWEA.SW문제해결응용;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// [SW 문제해결 응용] 4일차 - 보급로 173ms 34900KB

public class Prob1249 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine()); // 지도 크기

            // 입력

            int[][] map = new int[N][N]; // 지도
            int[][] ans = new int[N][N]; // 최소 복구 시간 저장

            for (int i = 0; i < N; i++) { // 파여진 도로의 깊이를 저장
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }

            // 실행

            sb.append("#" + testcase + " " + search(N, map, ans));
            System.out.println(sb);
        }
    }

    private static int search(int N, int[][] map, int[][] ans) {

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        Queue<Integer[]> q = new ArrayDeque<>();

        // 출발
        q.offer(new Integer[] { 0, 0 });
        ans[0][0] = 0;

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                Integer[] now = q.poll();

                for (int r = 0; r < 4; r++) {

                    int nr = now[0] + dr[r];
                    int nc = now[1] + dc[r];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                        continue;

                    // 더 최적의 경로를 찾았다면!
                    if (ans[nr][nc] > ans[now[0]][now[1]] + map[nr][nc]) {
                        ans[nr][nc] = ans[now[0]][now[1]] + map[nr][nc];
                        q.offer(new Integer[] { nr, nc });
                    }

                }
            }
        }
        return ans[N - 1][N - 1];
    }
}
