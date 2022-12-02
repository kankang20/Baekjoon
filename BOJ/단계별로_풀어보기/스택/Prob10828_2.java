package BOJ.단계별로_풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 스택 236ms 19880KB

public class Prob10828_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (stack.size() == 0)
                    sb.append(-1 + "\n");
                else {
                    sb.append(stack.get(stack.size() - 1) + "\n");
                    stack.remove(stack.size() - 1);
                }
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
                    sb.append(stack.get(stack.size() - 1) + "\n");
            }
        }

        System.out.println(sb);
    }
}