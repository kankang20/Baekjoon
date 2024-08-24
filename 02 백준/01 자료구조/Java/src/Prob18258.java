
/**
* title  : 18258. 큐 2 (Silver 4)
* time   : 1220ms
* memory : 407668KB
*/

import java.io.*;
import java.util.*;

public class Prob18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int lastElement = 0;

        for (int i = 0; i < N; i++) {

            String[] comm = (br.readLine()).split(" ");

            if (comm[0].equals("push")) {
                int element = Integer.parseInt(comm[1]);
                q.offer(element);
                lastElement = element;

            } else if (comm[0].equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");

            } else if (comm[0].equals("size")) {
                sb.append(q.size()).append("\n");
        
            } else if (comm[0].equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");

            } else if (comm[0].equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");

            } else if (comm[0].equals("back")) {
                sb.append(q.isEmpty() ? -1 : lastElement).append("\n");
            } 
        }
        
        System.out.println(sb);
    }
}