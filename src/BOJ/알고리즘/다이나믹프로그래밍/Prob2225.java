package BOJ.알고리즘.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 합분해 128ms 14328KB (java11) 76ms 11732KB (java8)
// 수학, 다이나믹 프로그래밍

public class Prob2225 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] map = new long[K + 1][N + 1]; // N을 K개의 숫자로 만드는 경우의 수

        for (int i = 0; i < N + 1; i++) {
            map[1][i] = 1; // 하나의 숫자로 수를 표현하는 방법은 항상 한가지 즉, 자기 자신
        }

        for (int i = 1; i < K + 1; i++) {
            map[i][0] = 1; // 몇개의 숫자를 사용하든 0을 표현하는 방법은 항상 한가지 0 0+0 0+0+0 ...
        }

        for (int i = 1; i < K + 1; i++) { // 행 하나씩 채우기 K
            for (int j = 1; j < N + 1; j++) { // N
                map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000000;
            }
        }

        sb.append(map[K][N]);
        System.out.println(sb);
    }
}
