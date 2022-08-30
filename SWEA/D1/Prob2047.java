package SWEA.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 신문 헤드라인
// 103ms 18388KB

public class Prob2047 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		sb.append(br.readLine().toUpperCase());

		System.out.println(sb);
		br.close();
	}
}
