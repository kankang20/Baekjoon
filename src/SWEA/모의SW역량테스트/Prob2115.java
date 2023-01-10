package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 벌꿀채취 143ms 32536KB

public class Prob2115 {

    private static int N, M, C; // 벌통의 크기, 선택할 수 있는 벌통의 개수, 채취할 수 있는 꿀의 최대 양
    private static int[][] map; // 각 벌통이 가진 꿀의 양
    private static int[][] selected; // 선택한 벌통의 양

    private static boolean[][] honey;
    private static int ans, honey1, honey2;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력
            // ///////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 벌통의 크기
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
            C = Integer.parseInt(st.nextToken()); // 채취할 수 있는 꿀의 최대 양

            map = new int[N][N]; // 벌통이 가진 꿀의 정보
            selected = new int[2][M];

            honey = new boolean[2][M];

            ans = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 실행 //////////////////////////////////////////////////////////////////////////

            /**
             * 1. 벌통을 선택한다
             * 2. 선택한 벌통의 이익을 구한다
             * 3. 비교해서 최대 이익을 구한다
             */

            selectbeehive(0, 0, 0);

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }

    }

    private static void selectbeehive(int cnt, int startx, int starty) {

        if (cnt == 2) {

            // 벌통을 선택해서 가능한 최대의 꿀을 채취한다
            honey1 = Integer.MIN_VALUE;
            honey2 = Integer.MIN_VALUE;

            selecthoney1(0, 0, 0);
            selecthoney2(0, 0, 0);

            ans = Math.max(honey1 + honey2, ans);
            return;
        }

        int end = N - M + 1;

        for (int i = startx; i < N; i++) {
            for (int j = 0; j < end; j++) {

                if (cnt == 0) { // 처음 선택하는 벌통이면
                    for (int b = 0; b < M; b++)
                        selected[cnt][b] = map[i][j + b];
                    selectbeehive(cnt + 1, i, j);
                } else { // 두번째로 선택하는 벌통이면
                    if ((i != startx) || (i == startx && j > starty + M - 1)) {
                        for (int b = 0; b < M; b++)
                            selected[cnt][b] = map[i][j + b];
                        selectbeehive(cnt + 1, i, j);
                    }
                }
            }
        }

    }

    private static void selecthoney1(int cnt, int sum, double price) {

        if (sum > C)
            return;

        if (cnt == M) {
            honey1 = (int) Math.max(honey1, price);
            return;
        }

        honey[0][cnt] = true;
        selecthoney1(cnt + 1, sum + selected[0][cnt], price + Math.pow(selected[0][cnt], 2));

        honey[0][cnt] = false;
        selecthoney1(cnt + 1, sum, price);

    }

    private static void selecthoney2(int cnt, int sum, double price) {

        if (sum > C)
            return;

        if (cnt == M) {
            honey2 = (int) Math.max(honey2, price);
            return;
        }

        if (sum > C)
            return;

        honey[1][cnt] = true;
        selecthoney2(cnt + 1, sum + selected[1][cnt], price + Math.pow(selected[1][cnt], 2));

        honey[1][cnt] = false;
        selecthoney2(cnt + 1, sum, price);
    }
}
