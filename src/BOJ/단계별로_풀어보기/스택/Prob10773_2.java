package BOJ.단계별로_풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로 252ms 23644KB

public class Prob10773_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int testCase = 0; testCase < K; testCase++) {

            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                int pop = stack.pop();
                sum -= pop;
            } else {
                stack.push(num);
                sum += num;
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}