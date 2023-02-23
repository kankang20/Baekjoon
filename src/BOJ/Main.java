package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /**
     * https://www.acmicpc.net/problem/14503
     *
     * 1. 현재 칸이 청소되지 않은 경우 현재 칸을 청소한다
     * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
     * == 전부 청소 되어 있거나 전부 벽이거나
     * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
     * == 반 시계 방향으로 90도 회전하면서 청소되어 있지 않은 구역을 찾아 전진
     *
     * 청소되어 있는 구역은 찾아가지 않는다! -> stackoverflow 발생
     */

    private static int R, C, sum;
    private static int[][] map;
    // 북 0 동 1 남 2 서 3
    private static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

//        robot = new int[3];

        st = new StringTokenizer(br.readLine());
//        robot[0] = Integer.parseInt(st.nextToken());    // 로봇청소기의 행
//        robot[1] = Integer.parseInt(st.nextToken());    // 로봇청소기의 열
//        robot[2] = Integer.parseInt(st.nextToken());    // 로봇청소기가 바라보는 방향 : 북 0 동 1 남 2 서 3

        map = new int[R][C];    // 1은 벽 0은 아직 청소하지 않은 구역

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning();

        System.out.println(sum);

    } // end main

    private static void cleaning() {

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {});

    } // end cleaning
}
