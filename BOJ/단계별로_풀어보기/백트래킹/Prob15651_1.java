package BOJ.단계별로_풀어보기.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3) 608ms 207272KB

public class Prob15651_1 {

	/** 1부터 N까지의 자연수 중에서 M개를 고른 수열 */

	static int N;
	static int M;

	static int[] numbers;

	static StringBuilder sb = new StringBuilder();

	private static void permutation(int cnt) {

		if (cnt == M) {
			for (int num : numbers)
				sb.append(num + " ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {

			numbers[cnt] = i;
			permutation(cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];

		permutation(0);

		System.out.println(sb);
	}
}