package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동 300ms 42156KB
// 그래프 이론, 그래프 탐색, 너비우선 탐색

public class Prob7562 {

    static int N; // 체스판 한변의 길이
    static Node current, goal; // 현재 위치, 목표 위치

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            current = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            goal = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            if (current.x == goal.x && current.y == goal.y)
                System.out.println(0);
            else
                chess(current);
        }
    } // main

    public static void chess(Node current) {

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] selected = new boolean[N][N];

        queue.offer(new Node(current.x, current.y, current.cnt));
        selected[current.x][current.y] = true;

        int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if ((node.x == goal.x && node.y == goal.y)) {
                System.out.println(node.cnt);
                return;
            }

            for (int j = 0; j < 8; j++) {
                int nr = node.x + dr[j];
                int nc = node.y + dc[j];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || selected[nr][nc])
                    continue;

                queue.offer(new Node(nr, nc, node.cnt + 1));
                selected[nr][nc] = true;
            }
        }
    } // chess
}
