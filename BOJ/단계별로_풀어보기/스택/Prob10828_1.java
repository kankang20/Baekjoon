package BOJ.단계별로_풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택 236ms 18620KB

public class Prob10828_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (stack.size() == 0)
                    sb.append(-1 + "\n");
                else
                    sb.append(stack.pop() + "\n");
            } else if (command.equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (command.equals("empty")) {
                if (stack.size() == 0)
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            } else if (command.equals("top")) {
                if (stack.size() == 0)
                    sb.append(-1 + "\n");
                else
                    sb.append(stack.peek() + "\n");
            }
        }

        System.out.println(sb);
    }
}