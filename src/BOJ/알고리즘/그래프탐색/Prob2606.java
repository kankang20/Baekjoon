package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스 124ms 14120KB (java11) 76ms 11692KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob2606 {

    private static int N, M; // 컴퓨터의 수, 연결되어 있는 컴퓨터 쌍의 수
    private static boolean map[][], visited[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 //////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            map[s][r] = map[r][s] = true;
        }

        // 실행 //////////////////////////////////////////////////////////////

        int ans = computer(1);

        sb.append(ans);
        System.out.println(sb);
    }

    private static int computer(int cnt) {

        int ans = 0;

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(cnt);
        visited[cnt] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int i = 1; i <= N; i++) {

                if (!visited[i] && map[now][i]) {
                    q.offer(i);
                    visited[i] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
