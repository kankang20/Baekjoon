
/**
* title  : 10845. 큐 (Silver 4)
* time   : 168ms
* memory : 20584KB
*/

import java.io.*;
import java.util.*;

public class Prob10845 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int lastElement = 0;

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] comm = (br.readLine()).split(" ");

            switch(comm[0]) {

                case "push":
                    int num = Integer.parseInt(comm[1]);
                    q.offer(num);
                    lastElement = num;
                    break;

                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                    break;

                case "back":
                    sb.append(q.isEmpty() ? -1 : lastElement).append("\n");
                    break;

                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
