package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 적록색약 180ms 16820KB
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob10026 {
    static int N;
	static char[][] map1, map2;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
        map2 = new char[N][N];

        int count1 = 0, count2 = 0;  // 그룹 개수
		
		// 그림 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map1[i][j] = map2[i][j] = line.charAt(j);
                if (map2[i][j] == 'G') map2[i][j] = 'R';
            }
        }

        // 그룹 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map1[i][j] != 'X') {
					group(i, j, map1);
					count1++;
				}

                if (map2[i][j] != 'X') {
					group(i, j, map2);
					count2++;
				}
			}
		}

        sb.append(count1 + " " + count2);
        System.out.println(sb);
	}
	
	static void group(int i, int j, char[][] map) {
		
		char text = map[i][j];
		
		Queue<Integer[]> q = new ArrayDeque<>();
        
        q.offer(new Integer[] {i, j});
        map[i][j] = 'X';

        while(!q.isEmpty()) {

            Integer[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 'X' || map[nr][nc] != text) continue;

                q.offer(new Integer[] {nr, nc});
                map[nr][nc] = 'X';
            }
        }
	}
}
