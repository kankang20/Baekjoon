package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유 1676ms 380716KB (java11) 1504ms 375768KB (java8) 
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob17129 {

    private static int N, M; // 정보섬 2층의 크기 N과 M
    private static int[][] map; // 정보섬 2층

    // 좌표 저장 - x 좌표, y 좌표, 딱따구리에서의 위치
    private static Queue<Integer[]> q = new ArrayDeque<>();
    private static boolean[][] selected; // 방문 여부

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        selected = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';

                if (map[i][j] == 2) { // 딱따구리의 시작 위치
                    q.offer(new Integer[] { i, j, 0 });
                    selected[i][j] = true;
                }
            }
        }

        // 실행 ////////////////////////////////////////////////////////////

        int ans = search();

        if (ans > 0)
            sb.append("TAK\n" + ans);
        else
            sb.append("NIE");

        System.out.println(sb);
    }

    private static int search() {

        // 사방 탐색
        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                Integer[] now = q.poll();

                for (int j = 0; j < 4; j++) {

                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M
                            || selected[nr][nc] || map[nr][nc] == 1)
                        continue;

                    int num = map[nr][nc];

                    if (num == 3 || num == 4 || num == 5)
                        return now[2] + 1;

                    q.offer(new Integer[] { nr, nc, now[2] + 1 });
                    selected[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}
