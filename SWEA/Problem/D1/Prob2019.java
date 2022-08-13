package SWEA.Problem.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 97ms 18696KB

public class Prob2019 {
    public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		int count = 1;

		for (int i = 0; i <= T; i++) {
			sb.append(count + " ");
			count *= 2;
		}

		System.out.println(sb);
		br.close();
	}
}
