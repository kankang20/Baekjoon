package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS 292ms 21256KB (java11) 196ms 18336KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob1260 {

    private static StringBuilder sb = new StringBuilder();

    private static int N, M, start; // 정점의 개수, 간선의 개수, 탐색을 시작할 정점
    private static boolean map[][], visited[]; // 방문 여부

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 ///////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        start = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점

        map = new boolean[N + 1][N + 1];

        int s = 0, d = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            map[s][d] = map[d][s] = true;
        }

        // 실행 ///////////////////////////////////////////////////////

        visited = new boolean[N + 1];
        DFS(start, 1);

        sb.append("\n");

        visited = new boolean[N + 1];
        BFS();

        System.out.println(sb);
    }

    private static void BFS() {

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            sb.append(now + " ");

            for (int i = 1; i <= N; i++) {

                if (!visited[i] && map[now][i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void DFS(int node, int cnt) {

        visited[node] = true;
        sb.append(node + " ");

        if (cnt == N)
            return;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && map[node][i]) {
                DFS(i, cnt + 1);
            }
        }
    }
}
