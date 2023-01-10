package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추 180ms 15804KB
// 그래프 이론, 그래프 탐색, 너비우선 탐색, 깊이우선 탐색

public class Prob1012 {
	static int[][] map;
	static Queue<Node> queue = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int col;
	static int row;

	static class Node {
		int y, x;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {

			sb = new StringBuilder();

			// 입력

			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			map = new int[row][col];

			int K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}

			// 실행

			int count = 0;

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 1) {
						cabbage(i, j);
						count++;
					}
				}
			}
			sb.append(count);
			System.out.println(sb);
		}
	}

	private static void cabbage(int x, int y) {

		queue.offer(new Node(x, y));
		map[x][y] = 0;

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			for (int d = 0; d < 4; d++) {

				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= col || nx >= row || map[nx][ny] == 0)
					continue;

				queue.offer(new Node(nx, ny));
				map[nx][ny] = 0;
			}
		}
	}
}
