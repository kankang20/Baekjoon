package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R, C, map[][], sum;
    // 북 0 동 1 남 2 서 3
    private static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nowr = Integer.parseInt(st.nextToken());
        int nowc = Integer.parseInt(st.nextToken());
        int nowd = Integer.parseInt(st.nextToken());

        map = new int[R][C];    // 1은 벽 0은 아직 청소하지 않은 구역

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning(nowr, nowc, nowd);

        sb.append(sum);
        System.out.println(sb);

    } // end main

    private static void cleaning(int row, int column, int dir) {

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {row, column, dir});
        map[row][column] = 2;
        sum += 1;

        while(!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {


                }
            }
        }



    } // end cleaning
}
