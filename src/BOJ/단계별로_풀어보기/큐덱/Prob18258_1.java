package BOJ.단계별로_풀어보기.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐 2 1568ms 349108KB

public class Prob18258_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> inQueue = new LinkedList<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    inQueue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (inQueue.size() == 0)
                        sb.append(-1 + "\n");
                    else
                        sb.append(inQueue.poll() + "\n");
                    break;
                case "size":
                    sb.append(inQueue.size() + "\n");
                    break;
                case "empty":
                    if (inQueue.size() == 0)
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                case "front":
                    if (inQueue.size() == 0)
                        sb.append(-1 + "\n");
                    else
                        sb.append(inQueue.peek() + "\n");
                    break;
                case "back":
                    if (inQueue.size() == 0)
                        sb.append(-1 + "\n");
                    else
                        sb.append(((LinkedList<Integer>) inQueue).get(inQueue.size() - 1) + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}