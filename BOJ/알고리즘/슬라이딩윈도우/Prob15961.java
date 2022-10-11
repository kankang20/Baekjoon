package BOJ.알고리즘.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 회전초밥 652ms 214724KB (java11) 616ms 212708KB (java8)
// 두 포인터, 슬라이딩 윈도우

public class Prob15961 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 /////////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushionbelt = new int[N]; // 벨트에 놓여있는 초밥
        int[] sushi = new int[d + 1]; // 초밥의 포함 여부

        for (int i = 0; i < N; i++) {
            sushionbelt[i] = Integer.parseInt(br.readLine());
        }

        // 실행 /////////////////////////////////////////////////////////////////////////

        Queue<Integer> q = new ArrayDeque<>();
        int max = Integer.MIN_VALUE; // 최대 가짓수

        int count = 0; // 초밥 개수
        for (int i = 0; i < k; i++) {

            q.offer(sushionbelt[i]);

            if (sushi[sushionbelt[i]] == 0) { // 스시가 포함되어 있지 않다면
                count++;
            }

            sushi[sushionbelt[i]]++;
        }

        if (sushi[c] == 0)
            max = Math.max(count + 1, max);
        else
            max = Math.max(count, max);

        for (int i = 0; i < N; i++) {

            int su = q.poll();

            if (sushi[su] == 1) {
                count--;
            }

            sushi[su]--;

            q.offer(sushionbelt[(i + k) % N]);

            if (sushi[sushionbelt[(i + k) % N]] == 0) { // 스시가 포함되어 있지 않다면
                count++;
            }

            sushi[sushionbelt[(i + k) % N]]++;

            if (sushi[c] == 0)
                max = Math.max(count + 1, max);
            else
                max = Math.max(count, max);
        }

        sb.append(max);
        System.out.println(sb);
    }
}
