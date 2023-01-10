package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 장훈이의 높은 선반 105ms 23860KB

public class Prob1486 {

    private static int N, B, H[]; // 점원 수, 선반 높이, 점원들의 키
    private static int ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            H = new int[N];
            ans = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int h = 0; h < N; h++) {
                H[h] = Integer.parseInt(st.nextToken());
            }

            // 실행 //////////////////////////////////////////////////////////////////////////

            top(0, 0);

            sb.append("#" + testcase + " ").append(ans - B);
            System.out.println(sb);
        }
    }

    private static void top(int cnt, int sum) {

        if (sum >= ans)
            return;

        if (cnt == N) {
            if (sum >= B && ans >= sum)
                ans = sum;
            return;
        }

        top(cnt + 1, sum + H[cnt]);
        top(cnt + 1, sum);
    }
}
