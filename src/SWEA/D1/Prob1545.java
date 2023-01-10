package SWEA.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 거꾸로 출력해 보아요
// 101ms 18408KB

public class Prob1545 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = T; i >= 0; i--) {
			sb.append(i + " ");
		}

		System.out.println(sb);
		br.close();
	}
}
