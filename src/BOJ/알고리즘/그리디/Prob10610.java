package BOJ.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 30 188ms 16612KB
// 수학, 문자열, 그리디, 정렬, 정수론

public class Prob10610 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기본 입력
        char[] input = br.readLine().toCharArray();

        Arrays.sort(input);

        long sum = 0;
        for (char c : input) {
            sum += c - '0';
        }

        if (input[0] == '0' && sum % 3 == 0) {
            for (int i = input.length - 1; i >= 0; i--) {
                sb.append(input[i]);
            }
        } else
            sb.append(-1);

        System.out.println(sb);

    }

}
