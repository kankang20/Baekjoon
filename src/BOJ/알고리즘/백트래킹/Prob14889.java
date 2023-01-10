package BOJ.알고리즘.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 스타트와 링크 552ms 20956KB
// 브루트포스, 백트래킹

// TO 시간을 줄이는 방법이 있지 않을까

public class Prob14889 {

    static int N;
    static long ans = Long.MAX_VALUE; // 사람 수, 최소 능력치 차이
    static int[][] map; // 능력치
    static int[] numbers;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기본 입력
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        numbers = new int[N / 2];
        selected = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 실행
        search(0, 1);

        sb.append(ans);
        System.out.println(sb);

    }

    private static void search(int cnt, int start) {

        if (cnt == N / 2) {
            Arrays.fill(selected, false);

            for (int i = 0; i < N / 2; i++) {
                selected[numbers[i]] = true;
            }
            ans = Math.min(ans, diff());
            return;
        }

        for (int i = start; i <= N; i++) {

            numbers[cnt] = i;
            search(cnt + 1, i + 1);
        }
    }

    private static long diff() {

        long start = 0;
        long link = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (selected[i] && selected[j])
                    start += (map[i][j] + map[j][i]);
                else if (!selected[i] && !selected[j])
                    link += (map[i][j] + map[j][i]);
            }
        }

        return Math.abs(start - link);
    }
}
