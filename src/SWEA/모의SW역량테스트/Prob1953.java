package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 탈주범 검거 128ms 36712KB

public class Prob1953 {

    private static int N, M, R, C, L;
    private static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지하 터널 지도의 행
            M = Integer.parseInt(st.nextToken()); // 지하 터널 지도의 열
            R = Integer.parseInt(st.nextToken()); // 맨홀의 행 위치
            C = Integer.parseInt(st.nextToken()); // 맨홀의 열 위치
            L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간

            // 지하터널
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = search();

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    }

    private static int search() {

        // 이동 방향
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        // 파이프 모양
        int[][] pipe = { {}, // 파이프 없음
                { 0, 1, 2, 3 }, // 타입1
                { 0, 1 }, // 타입2
                { 2, 3 }, // 타입3
                { 1, 2 }, // 타입4
                { 0, 2 }, // 타입5
                { 0, 3 }, // 타입6
                { 1, 3 } }; // 타입7
        // 파이프 연결 가능 여부 - 현재 위치에서의 방향과 그 다음 위치의 파이프 타입이 연결 가능한가?
        boolean[][] check = {
                { false, true, true, false, true, false, false, true },
                { false, true, true, false, false, true, true, false },
                { false, true, false, true, false, false, true, true },
                { false, true, false, true, true, true, false, false }
        };

        Queue<Integer[]> q = new ArrayDeque<>();

        // 방문 여부
        boolean[][] selected = new boolean[N][M];
        // 시작
        q.offer(new Integer[] { R, C });
        selected[R][C] = true;
        // 가능한 개수
        int count = 1; // 맨홀로 시작

        while (--L > 0 && !q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                Integer[] now = q.poll();

                int action = map[now[0]][now[1]];

                for (int j = 0, size = pipe[action].length; j < size; j++) {
                    int nr = now[0] + dir[pipe[action][j]][0];
                    int nc = now[1] + dir[pipe[action][j]][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || selected[nr][nc])
                        continue;

                    if (!check[pipe[action][j]][map[nr][nc]])
                        continue;

                    q.offer(new Integer[] { nr, nc });
                    selected[nr][nc] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
