
/**
* title  : 1844. 게임 맵 최단거리 (Level 2)
*/

import java.util.*;

public class Prob1844 {
    
    public static void main(String[] args) {

        int[][] m1 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(m1));

        int[][] m2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
        System.out.println(solution(m2));
    }

    public static int solution(int[][] maps) {

        int R = maps.length, C = maps[0].length;
        
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] selected = new boolean[R][C];

        q.add(new int[] {0, 0, 1});
        selected[0][0] = true;

        while (!q.isEmpty()) {

            int[] now = q.poll();

            if (now[0] == (R-1) && now[1] == (C-1)) return now[2];

            for (int d = 0; d < 4; d++) {

                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (selected[nr][nc] || maps[nr][nc] == 0) continue;

                q.add(new int[] {nr, nc, now[2] + 1});
                selected[nr][nc] = true;
            }
        }

        return -1;
    }
}
