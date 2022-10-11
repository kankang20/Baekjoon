package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 활주로 건설 115ms 33028KB

public class Prob4014 {

    private static int N, X; // 지도의 크기, 경사로의 길이
    private static int[][] map1, map2; // 지도

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 /////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map1 = new int[N][N]; // 행 -> 행
            map2 = new int[N][N]; // 열 -> 행

            for (int i = 0; i < N; i++) { // 하나의 함수로 계산하기 위해
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map1[i][j] = map2[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            // 실행 /////////////////////////////////////////////////////////////////////////

            int ans = 0;

            for (int i = 0; i < N; i++) {
                if (possible(map1[i]))
                    ans++;

                if (possible(map2[i]))
                    ans++;
            }

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    }

    private static boolean possible(int[] map) {

        int previous = map[0]; // 이전 높이
        int count = 1; // 반복된 높이 개수

        for (int i = 1; i < N; i++) {

            if (previous == map[i]) {
                count++;
            } else if (previous + 1 == map[i]) {

                if (count < X) // 경사로를 놓을 수 없음
                    return false;

                previous = map[i];
                count = 1;

            } else if (previous - 1 == map[i]) {

                for (int j = 0; j < X; j++) {
                    if ((i + j) >= N || map[i + j] != previous - 1)
                        return false;
                }

                i += X - 1;
                previous = map[i];
                count = 0;

            } else // 2 이상 차이나면 경사로 사용 불가능
                return false;
        }

        return true;
    }
}
