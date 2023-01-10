package SWEA.D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 오! 나의 여신님 121ms 26828KB

public class Prob7793 {

    private static int N, M; // 지도의 크기 행, 열
    private static char[][] map; // 지도

    private static class pos {
        int x, y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 초기화 안해서 11번 fail..ㅠㅜ
            Queue<pos> devil = new ArrayDeque<>();
            Queue<pos> su = new ArrayDeque<>();

            // 입력 /////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 행
            M = Integer.parseInt(st.nextToken()); // 열

            map = new char[N][M];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);

                    if (map[i][j] == '*') // 악마
                        devil.offer(new pos(i, j));
                    else if (map[i][j] == 'S') // 수연
                        su.offer(new pos(i, j));
                }
            }

            // 실행 /////////////////////////////////////////////////////////////

            int ans = ohgodness(devil, su);

            sb.append("#").append(testcase).append(" ");
            if (ans == -1)
                sb.append("GAME OVER");
            else
                sb.append(ans);

            System.out.println(sb);
        }
    }

    private static int ohgodness(Queue<pos> devil, Queue<pos> su) {

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        int count = 0;

        // 현재 수연이의 위치는 ‘S’, 여신의 공간은 ‘D’, 돌의 위치는 ‘X’, 악마는 ‘*’로 주어진다.
        while (!su.isEmpty()) {

            count++; // 한칸 이동

            // 악마 이동하세요
            for (int i = 0, end = devil.size(); i < end; i++) {

                pos now = devil.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now.x + dr[d];
                    int nc = now.y + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;

                    if (map[nr][nc] == 'S' || map[nr][nc] == '.') {
                        devil.offer(new pos(nr, nc));
                        map[nr][nc] = '*';
                    }
                }
            } // 악마 이동 완료

            // 수연이 이동하세요
            for (int i = 0, end = su.size(); i < end; i++) {

                pos now = su.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now.x + dr[d];
                    int nc = now.y + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;

                    if (map[nr][nc] == 'D')
                        return count;

                    if (map[nr][nc] == '.') {
                        su.offer(new pos(nr, nc));
                        map[nr][nc] = 'S';
                    }
                }
            } // 수연이 이동 완료
        }
        return -1;
    }
}