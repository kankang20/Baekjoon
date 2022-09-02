package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 데스나이트 140ms 14496KB
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob16948 {

    static int N;
    static int[] dr = { -2, -2, 0, 0, +2, +2 }; // 행 이동범위
    static int[] dc = { -1, +1, -2, +2, -1, +1 }; // 열 이동범위

    static class node { // 좌표의 행과 열의 위치 저장
        int r, c;

        public node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 체스판의 크기 입력받음
        N = Integer.parseInt(br.readLine());

        // 시작 노드와 목표 노드 입력받고 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        node start = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        node end = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        // 실행
        sb.append(chess(start, end));
        System.out.println(sb);
    }

    static int chess(node start, node end) {
        Queue<node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N]; // 방문여부

        int count = 0; // 이동횟수

        q.offer(start); // start 좌표에서 시작
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {

            int size = q.size();
            count++;

            // queue 안에 들어있는 노드들 실행
            for (int i = 0; i < size; i++) {
                node cur = q.poll(); // 하나씩 꺼내서 각자 이동범위 찾기

                for (int d = 0; d < 6; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr == end.r && nc == end.c)
                        return count; // 이동한 좌표가 목표 좌표와 같다면
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
                        continue; // 경계와 방문 여부

                    q.offer(new node(nr, nc)); // 이동가능한 범위로 이동
                    visited[nr][nc] = true;
                }
            }
        }
        return -1; // 목표에 도달하지 못했다면 -1 반환
    }
}
