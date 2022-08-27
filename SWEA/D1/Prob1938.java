package SWEA.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아주 간단한 계산기
// 103ms 18680KB

public class Prob1938 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		sb.append((a + b) + "\n");
		sb.append((a - b) + "\n");
		sb.append((a * b) + "\n");
		sb.append((a / b) + "\n");

		System.out.println(sb);
		br.close();
	}
}
