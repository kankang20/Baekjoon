package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 미생물 격리 479ms 39836KB

public class Prob2382 {

    private static int N, M, K; // 한 변의 셀 개수, 격리 시간, 미생물 군집 개수
    private static microbe map[][];

    private static PriorityQueue<microbe> q;

    private static class microbe implements Comparable<microbe> {
        int r, c, num, dir;

        public microbe(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num; // 미생물 수
            this.dir = dir; // 이동방향
        }

        @Override
        public int compareTo(microbe o) { // 큰 수가 먼저 나옴
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 한 변의 셀 개수
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수

            map = new microbe[N][N];
            q = new PriorityQueue<>();

            int r = 0, c = 0, num = 0, dir = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                r = Integer.parseInt(st.nextToken()); // 행
                c = Integer.parseInt(st.nextToken()); // 열
                num = Integer.parseInt(st.nextToken()); // 군집 안에서의 미생물 개수
                dir = Integer.parseInt(st.nextToken()); // 이동방향

                q.offer(new microbe(r, c, num, dir));
            }

            // 실행 //////////////////////////////////////////////////////////////////////////

            sb.append("#" + testcase + " " + microbe_move());
            System.out.println(sb);
        }
    } // end main

    private static int microbe_move() {

        int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

        int nr = 0, nc = 0, sum = 0;

        while (--M >= 0) {

            // 군집아 이동하자
            while (!q.isEmpty()) {

                microbe micro = q.poll();

                micro.r += dir[micro.dir][0];
                micro.c += dir[micro.dir][1];

                nr = micro.r;
                nc = micro.c;

                // 약품ㅠㅜ
                if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {

                    micro.num /= 2;

                    if (micro.num == 0)
                        continue;

                    if (micro.dir == 1 || micro.dir == 3)
                        micro.dir++;
                    else
                        micro.dir--;
                }

                if (map[nr][nc] == null) {
                    map[nr][nc] = micro;
                } else {
                    map[nr][nc].num += micro.num;
                }
            }

            sum = init();
        }

        return sum;
    } // end microbe_move

    private static int init() {

        int allcount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j] == null)
                    continue;

                allcount += map[i][j].num;
                q.offer(map[i][j]);

                map[i][j] = null;
            }
        }

        return allcount;
    } // end init
}
