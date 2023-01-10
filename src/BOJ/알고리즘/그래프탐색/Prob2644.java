package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 촌수 계산 124ms 14276KB (java11) 80ms 11656KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob2644 {

    private static int N;
    private static boolean map[][], visited[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 //////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine()); // 전체 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수

        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s][e] = map[e][s] = true;
        }

        // 실행 //////////////////////////////////////////////////////////

        int ans = count_parent(start, end);

        sb.append(ans);
        System.out.println(sb);
    }

    private static int count_parent(int start, int end) {

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { start, 0 });
        visited[start] = true;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                int[] now = q.poll();

                for (int j = 1; j <= N; j++) {

                    if (!visited[j] && map[now[0]][j]) {

                        if (j == end)
                            return (now[1] + 1);

                        q.offer(new int[] { j, now[1] + 1 });
                        visited[j] = true;
                    }
                }
            }
        }

        return -1;
    }
}
