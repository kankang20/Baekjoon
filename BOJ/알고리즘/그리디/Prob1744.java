package BOJ.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 묶기 124ms 14360KB (java11) 76ms 11492KB (java8)
// 그리디 알고리즘, 정렬, 많은 조건 분기

public class Prob1744 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 /////////////////////////////////////////////////////////////

        int N = Integer.parseInt(br.readLine());
        int minus = 0; // 입력되는 수 중에서 음수와 0 개수

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());

            if (numbers[i] <= 0)
                minus++;
        }

        // 출력 /////////////////////////////////////////////////////////////

        int max = 0; // 최대 값

        if (N == 1) {
            max = numbers[0];
        } else {

            Arrays.sort(numbers);

            // 음수와 0 처리 ////////////////////////////////////////////////

            if (minus % 2 == 0) { // 음수의 개수가 짝수이면
                for (int i = 0; i < minus; i++) {
                    max += numbers[i] * numbers[++i];
                }
            } else { // 음수의 개수가 홀수이면
                for (int i = 0; i < minus - 1; i++) {
                    max += numbers[i] * numbers[++i];
                }
                max += numbers[minus - 1];
            }

            // 양수 처리 ///////////////////////////////////////////////////

            for (int i = N - 1; i >= minus; i--) {

                if (i == minus) {
                    max += numbers[minus];
                    continue;
                }

                if (numbers[i] == 1 || numbers[i - 1] == 1) {
                    max += numbers[i] + numbers[--i];
                } else {
                    max += numbers[i] * numbers[--i];
                }
            }

        }

        sb.append(max);
        System.out.println(sb);
    }
}
