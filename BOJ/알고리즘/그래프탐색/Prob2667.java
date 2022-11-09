package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 단지번호 붙이기 144ms 15808KB (java11) 80ms 11616KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob2667 {

    private static int N;
    private static char[][] map;
    private static boolean[][] visited;

    private static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 //////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine()); // 지도의 크기

        map = new char[N][];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 실행 //////////////////////////////////////////////////////////

        int count = 0; // 단지 개수
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    list.add(house_count(i, j));
                    count++;
                }
            }
        }

        sb.append(count + "\n");

        list.sort(null);

        for (int num : list) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }

    private static int house_count(int r, int c) {

        int count = 1;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { r, c });
        visited[r][c] = true;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now[0] + dir[d][0];
                    int nc = now[1] + dir[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == '0')
                        continue;

                    q.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;

                    count++;
                }
            }
        }
        return count;
    }
}
