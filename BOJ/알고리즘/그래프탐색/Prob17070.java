package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기1 220ms 16068KB (java11) 164ms 12676KB(java8)
// 그래프 이론, 그래프 탐색, 다이나믹 프로그래밍

public class Prob17070 {

    private static int N, ans; // 집 크기, 방법의 개수
    private static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        N = Integer.parseInt(br.readLine()); // 집의 크기

        map = new int[N][N]; // 집

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 실행
        search(0, 1, 1);

        sb.append(ans);
        System.out.println(sb);
    }

    private static void search(int x, int y, int dir) {

        // dir = 1이면 가로 2이면 세로 3이면 대각선

        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }

        int nx = x + 1;
        int ny = y + 1;

        switch (dir) {
            case 1: // 가로이면
                if (ny < N && map[x][ny] == 0)
                    search(x, ny, 1);
                if (nx < N && ny < N && map[x][ny] == 0 && map[nx][y] == 0 && map[nx][ny] == 0)
                    search(nx, ny, 3);
                break;
            case 2: // 세로면
                if (nx < N && map[nx][y] == 0)
                    search(nx, y, 2);
                if (nx < N && ny < N && map[x][ny] == 0 && map[nx][y] == 0 && map[nx][ny] == 0)
                    search(nx, ny, 3);
                break;
            case 3: // 대각선이면
                if (ny < N && map[x][ny] == 0)
                    search(x, ny, 1);
                if (nx < N && map[nx][y] == 0)
                    search(nx, y, 2);
                if (nx < N && ny < N && map[x][ny] == 0 && map[nx][y] == 0 && map[nx][ny] == 0)
                    search(nx, ny, 3);
                break;
        }
    }
}
