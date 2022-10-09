package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기 160ms 15216KB (java11) 112ms 13264KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob9205 {

    private static int N; // 편의점 + 집 + 페스티벌 개수
    private static boolean[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            sb = new StringBuilder();

            N = Integer.parseInt(br.readLine()) + 2;

            int[][] nodes = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                nodes[i][0] = Integer.parseInt(st.nextToken());
                nodes[i][1] = Integer.parseInt(st.nextToken());
            }

            map = new boolean[N][N];

            // 이동 가능 여부 파악
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (Math.abs(nodes[i][0] - nodes[j][0]) + Math.abs(nodes[i][1] - nodes[j][1]) <= 1000) {
                        map[i][j] = true;
                        map[j][i] = true;
                    }
                }
            }

            sb.append(festival() ? "happy" : "sad");
            System.out.println(sb);
        }
    }

    private static boolean festival() {

        Queue<Integer> q = new ArrayDeque<>();

        boolean[] selected = new boolean[N];

        q.offer(0);
        selected[0] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int i = 1; i < N; i++) {

                if (map[now][i]) {

                    if (i == N - 1)
                        return true;

                    if (!selected[i]) {
                        q.offer(i);
                        selected[i] = true;
                    }
                }
            }
        }
        return false;

    }
}
