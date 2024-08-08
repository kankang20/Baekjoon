package 위상정렬;

import java.io.*;
import java.util.*;

public class Prob2056 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> working = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            working.add(new ArrayList<>());
        }

        int[] time = new int[N+1];
        int[] indegree = new int[N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int node = Integer.parseInt(st.nextToken());
                working.get(node).add(i);
                indegree[i]++;
            }
        }

        System.out.println(topologicalSort(N, working, time, indegree));

    }

    public static int topologicalSort(int N, List<List<Integer>> working, int[] time, int[] indegree) {

        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int now = q.poll();
            for (int temp : working.get(now)) {

                result[temp] = Math.max(result[temp], result[now] + time[temp]);

                if (--indegree[temp] == 0) {
                    q.offer(temp);
                }
            }
        }

        int answer = 0;
        for (int r : result) {
            answer = Math.max(r, answer);
        }

        return answer;
    }
}
