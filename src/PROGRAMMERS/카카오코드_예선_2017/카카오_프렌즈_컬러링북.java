package PROGRAMMERS.카카오코드_예선_2017;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 카카오_프렌즈_컬러링북 {

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0},
                            {1, 2, 2, 0},
                            {1, 0, 0, 1},
                            {0, 0, 0, 1},
                            {0, 0, 0, 3},
                            {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m, n, picture)));
    }

    private static int R, C;
    private static boolean[][] selected;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        selected = new boolean[m][n];

        R = m;
        C = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(picture[i][j] > 0 && !selected[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, i, j));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int[][] picture, int row, int column) {

        int sum = 1;

        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new ArrayDeque<>();

        int color = picture[row][column];

        q.offer(new int[] {row, column});
        selected[row][column] = true;

        while(!q.isEmpty()) {

            for (int r = 0, end = q.size(); r < end; r++) {

                int[] now = q.poll();

                for (int d = 0; d < 4; d++) {

                    assert now != null;
                    int nr = now[0] + dir[d][0];
                    int nc = now[1] + dir[d][1];

                    if(nr < 0 || nc < 0 || nr >= R || nc >= C || selected[nr][nc] || picture[nr][nc] != color) continue;

                    q.offer(new int[] {nr, nc});
                    selected[nr][nc] = true;
                    sum++;

                } // end for
            } // end for
        } // end while
        return sum;
    } // end bfs
}
