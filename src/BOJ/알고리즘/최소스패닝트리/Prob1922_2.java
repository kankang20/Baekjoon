package BOJ.알고리즘.최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 네트워크 연결 2624ms 46716KB (java11) 2288ms 44372KB (java8)
// 그래프 이론, 최소 스패닝 트리 prim

public class Prob1922_2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기본 입력

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 선의 수

        int[][] map = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        ArrayList<Integer> selected = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = map[to][from] = Integer.parseInt(st.nextToken());
        }

        // 실행

        int min, index, result = 0;

        selected.add(1);
        visited[1] = true;

        for (int i = 0; i < N - 1; i++) {
            min = Integer.MAX_VALUE;
            index = 0;

            for (Integer v : selected) {

                for (int j = 1; j < N + 1; j++) {
                    if (map[v][j] != 0 && !visited[j] && map[v][j] < min) {
                        min = map[v][j];
                        index = j;
                    }
                }
            }

            selected.add(index);
            result += min;
            visited[index] = true;
        }

        // 결과

        sb.append(result);
        System.out.println(sb);
    }
}
