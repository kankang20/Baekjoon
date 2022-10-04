package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 수영장 101ms 23916KB

public class Prob1952 {

    private static int[] prices = new int[4]; // 1일, 1달, 3달, 1년 이용권의 요금
    private static int[] plan = new int[12];

    private static int ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 이용권 가격
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            // 12개월 이용계획
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // 초기화
            ans = prices[3];

            // 실행
            swimming(0, 0);

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    }

    private static void swimming(int cnt, int price) {

        if (cnt >= 12) {
            ans = Math.min(ans, price);
            return;
        }

        if (price >= ans)
            return;

        swimming(cnt + 1, price + Math.min(plan[cnt] * prices[0], prices[1])); // 1일 / 1달 이용권
        swimming(cnt + 3, price + prices[2]); // 3달 이용권

    }
}
