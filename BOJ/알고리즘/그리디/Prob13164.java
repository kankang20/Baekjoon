package BOJ.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 행복 유치원 688ms 51464KB (java11) 420ms 64348KB (java8)
// 그리디, 정렬

public class Prob13164 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기본 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원생 수
        int K = Integer.parseInt(st.nextToken()); // 조 개수

        long[] inputs = new long[N]; // 원생들의 키
        long[] diff = new long[N - 1]; // 인접한 원생들의 키 차이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 오름차순 순서로 입력이 주어짐
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) { // 인접한 원생들의 키 차이
            diff[i - 1] = inputs[i] - inputs[i - 1];
        }

        // 실행

        if (N == K) // 원생 수와 조의 수가 같으면 0
            sb.append(0);
        else { // 원생 수와 조의 수가 다르면
            Arrays.sort(diff);

            long sum = 0;
            for (int i = 0, end = N - K; i < end; i++) {
                sum += diff[i];
            }

            sb.append(sum);
        }

        // 출력
        System.out.println(sb);
    }
}
