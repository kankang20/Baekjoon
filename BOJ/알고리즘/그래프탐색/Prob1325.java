package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 효율적인 해킹 시간초과
// 그래프 이론, 그래프 탐색, 너비우선 탐색, 깊이우선 탐색

public class Prob1325 {
	static node[] nodes;
	static int[] counts;

	static int count;

	public static class node {
		int A;
		int B;

		public node(int A, int B) {
			this.A = A;
			this.B = B;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		nodes = new node[M];
		counts = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// A가 B를 신뢰한다. -> B를 해킹하면 A도 해킹할 수 있다.
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			nodes[i] = new node(A, B);
		}

		int maxcount = 0;

		for (int i = 1; i <= N; i++) {
			count = 1;
			computer(i);
			counts[i] = count;
			if (maxcount < count)
				maxcount = count;
		}

		for (int i = 1; i < N + 1; i++) {
			if (maxcount == counts[i])
				sb.append(i + " ");
		}

		System.out.println(sb);
	}

	public static void computer(int idx) {

		for (int i = 0, size = nodes.length; i < size; i++) {
			if (nodes[i].B == idx) {
				count++;
				computer(nodes[i].A);
			}
		}
	}
}
