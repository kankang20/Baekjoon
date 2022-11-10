package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트링크 208ms 38988KB (java11) 164ms 37248KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob7569 {

    private static int F, S, G, U, D;
    private static boolean visited[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 건물의 전체 층수
        S = Integer.parseInt(st.nextToken()); // 강호의 현재 층수
        G = Integer.parseInt(st.nextToken()); // 강호의 목표 층수 - 스타트링크
        U = Integer.parseInt(st.nextToken()); // 위로 U층 갈 수 있음
        D = Integer.parseInt(st.nextToken()); // 아래로 D층 갈 수 있음

        visited = new boolean[F + 1];

        // 실행 ////////////////////////////////////////

        int ans = elevator();

        sb.append(ans > -1 ? ans : "use the stairs");
        System.out.println(sb);
    }

    private static int elevator() {

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { S, 0 });
        visited[S] = true;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                int[] now = q.poll();

                if (now[0] == G)
                    return now[1];

                int up = now[0] + U;

                if (up <= F && !visited[up]) {
                    q.offer(new int[] { up, now[1] + 1 });
                    visited[up] = true;
                }

                int down = now[0] - D;

                if (down >= 1 && !visited[down]) {
                    q.offer(new int[] { down, now[1] + 1 });
                    visited[down] = true;
                }
            }
        }

        return -1;
    }
}
