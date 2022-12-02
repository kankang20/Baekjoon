package BOJ.단계별로_풀어보기.큐덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 카드2 208ms 55840KB

public class Prob2164_1 {

	static Queue<Integer> queue = new ArrayDeque<>();
	static int last;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		CardMove(N);

		sb.append(last);
		System.out.println(sb);
	}

	private static void CardMove(int cnt) {

		if (cnt == 1) {
			last = queue.peek();
			return;
		}

		queue.poll(); // 제일 위에 있는 카드를 버리고
		queue.offer(queue.poll()); // 제일 위에 있는 카드를 제일 아래로 옮긴다
		CardMove(cnt - 1);
	}
}