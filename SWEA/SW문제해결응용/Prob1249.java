package SWEA.SW문제해결응용;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// [SW 문제해결 응용] 4일차 - 보급로 173ms 34900KB

public class Prob1249 {

    private static int N, map[][], memo[][];

    private static int[] dr = { 0, 0, -1, 1 };
    private static int[] dc = { -1, 1, 0, 0 };

    private static class node {
        int r, c;

        public node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 /////////////////////////////////////////////////

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            memo = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    memo[i][j] = Integer.MAX_VALUE;
                }
            }

            // 실행 /////////////////////////////////////////////////

            move();

            sb.append("#" + testcase + " " + memo[N - 1][N - 1]);
            System.out.println(sb);

        } // end for
    } // end main

    private static void move() {

        Queue<node> q = new ArrayDeque<>();

        q.offer(new node(0, 0));
        memo[0][0] = 0;

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                node now = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                        continue;

                    if (memo[now.r][now.c] + map[nr][nc] < memo[nr][nc]) {
                        memo[nr][nc] = memo[now.r][now.c] + map[nr][nc];
                        q.offer(new node(nr, nc));
                    }
                }
            }
        }
    } // end move

}
