
/**
 * title  : 1764. 듣보잡 (Silver 4)
 * time   : 252ms
 * memory : 26136KB
 */

import java.io.*;
import java.util.*;

public class Prob1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> nameSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nameSet.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (nameSet.contains(name)) {
                answer.add(name);
            }
        }

        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for (String ans : answer) {
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}