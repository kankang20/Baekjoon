package BOJ.단계별로_풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 스택 364ms 19400KB

public class Prob10828_3 {
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
                    System.out.println(-1);
                else {
                    System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                if (stack.size() == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (command.equals("top")) {
                if (stack.size() == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.get(stack.size() - 1));
            }
        }

        System.out.println(sb);
    }
}