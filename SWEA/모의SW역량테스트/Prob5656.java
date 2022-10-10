package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 벽돌깨기 868ms 104356KB

public class Prob5656 {

    private static int N, R, C; // 구술 슈팅 횟수, map의 크기 행, 열
    private static int[][] map, mmap; // 구슬 정보를 포함한 map

    private static int[] shooting; // 슈팅 위치

    private static int[] dr = { 0, 0, -1, 1 }; // 사방탐색 행
    private static int[] dc = { -1, 1, 0, 0 }; // 사방탐색 열

    private static int allBricks, bricks, ans; // 총 벽돌의 개수, 각 게임에서의 벽돌 수, 최종 벽돌 개수 (최소)

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 ///////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 슈팅 횟수
            C = Integer.parseInt(st.nextToken()); // 열
            R = Integer.parseInt(st.nextToken()); // 행

            map = new int[R][C]; // 원본 지도
            mmap = new int[R][C]; // 복사본 지도
            shooting = new int[N]; // 슈팅할 위치 저장

            ans = Integer.MAX_VALUE;
            allBricks = 0;

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] > 0)
                        allBricks++; // 전체 벽돌의 개수
                }
            }

            // 실행 ///////////////////////////////////////////////////

            // 1. 슈팅할 위치를 중복 순열로 - complete
            // 2. 배열을 copy해서 구슬이 슈팅 되었을 때 삭제되어 남을 벽돌의 개수를 계산
            // 2-1. 벽돌 삭제
            // 2-2. 벽돌 정리
            // 3. 최소인 남은 벽돌의 개수 구하기

            where_shooting(0);

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    }

    // 슈팅 위치 결정 - 중복순열
    private static void where_shooting(int cnt) {

        if (cnt == N) {

            mmap = copy_map(); // 지도 복사
            bricks = allBricks; // 벽돌 개수

            // 게임 시작
            for (int k = 0; k < N; k++) {

                int i = shooting[k];
                int startr = 0; // 슈팅 시작 위치

                while (startr < R && mmap[startr][i] == 0)
                    ++startr;

                if (startr < R) { // 슈팅할 벽돌이 있음
                    shooting(startr, i); // 슈팅 + 남아 있는 벽돌 수 계산
                    if (bricks == 0) // 만약 벽돌이 다 삭제되었다면 끝
                        break;
                    setting_bricks(); // 벽돌 정리
                }

            }
            ans = Math.min(ans, bricks);
            return;
        }

        for (int i = 0; i < C; i++) {
            shooting[cnt] = i;
            where_shooting(cnt + 1);
        }

    } // end where_shooting

    private static int[][] copy_map() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                mmap[i][j] = map[i][j];
            }
        }

        return mmap;
    } // end copy_map

    private static void shooting(int startr, int startc) {

        Queue<int[]> q = new ArrayDeque<>();

        // 슈팅할 벽돌이 있음
        if (mmap[startr][startc] > 1) {
            q.offer(new int[] { startr, startc, mmap[startr][startc] - 1 });
        }

        mmap[startr][startc] = 0;
        bricks--;

        while (!q.isEmpty()) {
            for (int i = 0, end = q.size(); i < end; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now[0];
                    int nc = now[1];

                    for (int j = 0; j < now[2]; j++) {
                        nr += dr[d];
                        nc += dc[d];

                        if (nr < 0 || nr >= R || nc < 0 || nc >= C || mmap[nr][nc] == 0)
                            continue;

                        if (mmap[nr][nc] > 1) {
                            q.offer(new int[] { nr, nc, mmap[nr][nc] - 1 });
                        }

                        mmap[nr][nc] = 0;
                        bricks--;
                    }
                }
            }
        }
    } // end shooting

    private static void setting_bricks() {

        for (int i = 0; i < C; i++) { // 모든 열에 대해서

            int row = R - 1;

            while (row > 0) {

                if (mmap[row][i] == 0) {
                    int r = row - 1;
                    while (r > 0 && mmap[r][i] == 0)
                        r--;
                    mmap[row][i] = mmap[r][i];
                    mmap[r][i] = 0;
                }

                row--;
            }
        }
    } // end setting_bricks
}
