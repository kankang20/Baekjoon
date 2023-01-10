package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소 528ms 100624KB (java11) 428ms 93220KB (java8)
// 구현, 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색

public class Prob14502 {

    private static int N, M, safezone; // 지도의 세로 크기, 가로 크기, 안전지대 개수
    private static int[][] map, select_wall; // 지도, 선택한 벽의 위치
    private static boolean[][] selected; // 바이러스가 퍼질 수 있는 공간 파악

    private static List<int[]> virus = new ArrayList<>(); // 시작 바이러스 위치
    private static int ans = Integer.MIN_VALUE; // 최대 안전지대 개수

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        map = new int[N][M];
        selected = new boolean[N][M];

        select_wall = new int[3][]; // 벽은 꼭 3개를 세워야 한다

        // 0은 빈칸, 1은 벽, 2는 바이러스
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0) // 빈칸이 아니면 바이러스가 퍼질 수 없기 때문에 선택 완료 표시
                    selected[i][j] = true;
                else // 빈칸이면 안전지대로 가능하기 때문에
                    safezone++;

                if (map[i][j] == 2) // 바이러스의 위치 저장
                    virus.add(new int[] { i, j });
            }
        }

        // 실행 ////////////////////////////////////////////////////////////

        // 벽의 3개를 선택하고
        // 안전지대를 구함

        select_walls(0, 0);

        sb.append(ans);
        System.out.println(sb);
    }

    private static void select_walls(int cnt, int start) {

        if (cnt == 3) { // 벽 3개를 선택 완료
            ans = Math.max(ans, spread_virus(copy_map())); // 안전지대 구하기
            return;
        }

        // 벽 선택 - 2차 배열을 1차 배열로
        for (int i = start; i < N * M; i++) {

            int r = i / M; // 행
            int c = i % M; // 열

            select_wall[cnt] = new int[] { r, c };
            select_walls(cnt + 1, i + 1);
        }
    }

    private static boolean[][] copy_map() {

        boolean[][] copy = new boolean[N][M];

        for (int i = 0; i < N; i++) { // 선택 표시 완료
            for (int j = 0; j < M; j++) {
                copy[i][j] = selected[i][j];
            }
        }

        for (int i = 0; i < 3; i++) { // 선택한 벽 3개 선택 완료 표시
            copy[select_wall[i][0]][select_wall[i][1]] = true;
        }

        return copy;
    }

    private static int spread_virus(boolean[][] selected) {

        int safe = safezone - 3; // 안전지대 개수 (이미 벽을 3개 선택했기 때문에)

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        Queue<int[]> q = new ArrayDeque<>();

        // 바이러스 시작
        for (int i = 0, end = virus.size(); i < end; i++) {
            q.offer(virus.get(i));
        }

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int[] now = q.poll();

                for (int j = 0; j < 4; j++) { // 사방
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || selected[nr][nc])
                        continue; // 크기를 넘어가거나 이미 선택 완료된 공간이면 필요 없음

                    q.offer(new int[] { nr, nc }); // 바이러스 감염
                    selected[nr][nc] = true;

                    safe--; // 안전지대 감소
                }
            }
        }

        return safe;
    }
}
