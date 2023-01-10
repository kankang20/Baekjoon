package BOJ.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 에너지드링크 456ms 31156KB
// 그리디

public class Prob20115 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 에너지드링크 수
        int[] amount = new int[N]; // 각 에너지 드링크 양

        // 에너지 드링크 양 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            amount[i] = Integer.parseInt(st.nextToken());
        }

        // 실행
        Arrays.sort(amount); // 정렬

        double ans = amount[N - 1]; // 가장 큰 수 더하기
        for (int i = 0; i < N - 1; i++) { // 수 비교해서 계산
            if (ans >= amount[i])
                ans += amount[i] / 2.0;
            else
                ans = ans / 2 + amount[i];
        }

        sb.append(ans);
        System.out.println(sb);
    }
}
