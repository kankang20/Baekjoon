package SWEA.Problem.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 95ms 18656KB

public class Prob2058 {
    public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		int sum = 0;

		while (T > 0) {
			sum += (T%10);
			T /= 10;
		}

		sb.append(sum);

		System.out.println(sb);
		br.close();
	}
}
