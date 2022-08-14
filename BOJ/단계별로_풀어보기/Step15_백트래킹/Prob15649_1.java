package BOJ.단계별로_풀어보기.Step15_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 332ms 34412KB

public class Prob15649_1 {

	/** 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 */
	
	static int N;
	static int M;
	
	static int[] numbers;
	static boolean[] selected;
	
	static StringBuilder sb = new StringBuilder();
	
	private static void permutation(int cnt) {
		
		if (cnt == M) {
			for (int num : numbers) sb.append(num + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {

			if(selected[i]) continue;
			
			numbers[cnt] = i;
			selected[i] = true;
			permutation(cnt+1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		selected = new boolean[N+1];
		
		permutation(0);
		
		System.out.println(sb);
	}
}