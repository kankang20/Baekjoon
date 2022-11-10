package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 696ms 106976KB (java11) 644ms 104580KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob5014 {

    private static int C, R, H, map[][][];
    private static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[R][C][H];

        int notomato = 0;

        // 1은 익은 토마토, 0은 익지 않은 토마토, -1은 비어있는 칸

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j][h] = Integer.parseInt(st.nextToken());

                    if (map[i][j][h] == 0)
                        notomato++;
                    else if (map[i][j][h] == 1)
                        q.offer(new int[] { i, j, h, 0 });
                }
            }
        }

        // 실행 ////////////////////////////////////////

        if (notomato == 0) {
            sb.append(0);
        } else {
            int ans = tomato(notomato);
            sb.append(ans > -1 ? ans : -1);
        }

        System.out.println(sb);
    }

    private static int tomato(int notomato) {

        int[][] dir = { { 0, 0, 1 }, { 0, 0, -1 }, { -1, 0, 0 },
                { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 } };

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 6; d++) {

                    int nr = now[0] + dir[d][0];
                    int nc = now[1] + dir[d][1];
                    int nh = now[2] + dir[d][2];

                    // 범위 벗어나면
                    if (nr < 0 || nc < 0 || nh < 0 || nr >= R || nc >= C || nh >= H)
                        continue;

                    // 익지않은 토마토가 없으면
                    if (map[nr][nc][nh] == -1 || map[nr][nc][nh] == 1)
                        continue;

                    if (--notomato == 0)
                        return (now[3] + 1);

                    q.offer(new int[] { nr, nc, nh, now[3] + 1 });
                    map[nr][nc][nh] = 1;
                }
            }
        }
        return -1;
    }

}
