package BOJ.알고리즘2.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// Silver 3. 바이러스

public class Prob2606 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // 컴퓨터의 수
        int count = Integer.parseInt(br.readLine());    // 연결되어 있는 컴퓨터 쌍의 수

        boolean[][] map = new boolean[N][N];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            map[start][end] = true;
            map[end][start] = true;
        }

        sb.append(virus(N, map));
        System.out.println(sb);

    } // end main

    private static int virus(int n, boolean[][] map) {

        boolean[] computer = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);
        computer[0] = true;

        int count = 0;

        while(!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int now = q.poll();

                for (int j = 0; j < n; j++) {

                    if(computer[j] || !map[now][j]) continue;

                    q.offer(j);
                    computer[j] = true;

                    count++;
                }
            }
        } // end while

        return count;
    } // end virus
}
