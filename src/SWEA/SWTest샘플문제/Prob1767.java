package SWEA.SWTest샘플문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [SW Test 샘플문제] 프로세서 연결하기 815ms 33384KB

public class Prob1767 {

    private static int N, coreCount, map[][]; // 맵의 크기, 코어 개수, 맵
    private static int maxCore, minLink; // 연결 가능할 때의 코어 개수, 전선 길이
    private static List<int[]> list; // 프로세서 저장

    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            N = Integer.parseInt(br.readLine()); // map의 크기

            map = new int[N][N];
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (i > 0 && j > 0 && i < N - 1 && j < N - 1 && map[i][j] == 1) {
                        // 가장자리에 위치하지 않은 프로세스만 저장
                        list.add(new int[] { i, j });
                    }
                }
            }

            coreCount = list.size(); // 코어 총 개수

            maxCore = Integer.MIN_VALUE; // 코어 개수
            minLink = Integer.MAX_VALUE; // 링크 길이

            // 실행 //////////////////////////////////////////////////////////////////////////

            // 프로세스 선택 -> 가능한 전선 연결 -> 코어는 최대개수 전선은 최소
            linkProcess(0, 0, 0);

            sb.append("#" + testcase + " " + minLink);
            System.out.println(sb);
        }
    }

    private static void linkProcess(int cnt, int core, int link) {

        if (cnt == coreCount) { // 모든 코어를 고려 완료하였을 때

            if (maxCore == core) { // 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라.
                minLink = Math.min(minLink, link);
            } else if (maxCore < core) { // 최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하고자 한다.
                maxCore = core;
                minLink = link;
            }

            return;
        }

        int r = list.get(cnt)[0];
        int c = list.get(cnt)[1];

        int nr = 0, nc = 0, len = 0;

        for (int d = 0; d < 4; d++) {

            nr = r;
            nc = c;
            len = 0;

            while (true) {

                nr += dr[d];
                nc += dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) // 벽을 만남 - 전선 최종 연결 성공
                    break;

                if (map[nr][nc] == 1) { // 다른 프로세스 또는 다른 전선을 만났을 경우
                    len = 0; // 전선 초기화
                    break;
                }

                len++; // 전선 하나 연결 성공
            }

            if (len == 0) { // 최종 연결 실패

                linkProcess(cnt + 1, core, link);

            } else { // 최종 연결 성공

                nr = r;
                nc = c;

                for (int i = 0; i < len; i++) { // 연결 성공한 전선 표시
                    nr += dr[d];
                    nc += dc[d];

                    map[nr][nc] = 1;
                }

                linkProcess(cnt + 1, core + 1, link + len);

                nr = r;
                nc = c;

                for (int i = 0; i < len; i++) { // 새로운 경우를 위해 전선 삭제
                    nr += dr[d];
                    nc += dc[d];

                    map[nr][nc] = 0;
                }
            }
        }
    }
}
