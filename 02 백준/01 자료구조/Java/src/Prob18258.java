
/**
* title  : 18258. 큐 2 (Silver 4)
* time   : 1248ms
* memory : 408720KB
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
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }

            } else if (comm[0].equals("size")) {
                sb.append(q.size()).append("\n");
        
            } else if (comm[0].equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else if (comm[0].equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }

            } else if (comm[0].equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(lastElement).append("\n");
                }
            } 
        }
        
        System.out.println(sb);
    }
}