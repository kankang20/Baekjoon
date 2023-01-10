package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 숫자 만들기 119ms 28664KB

public class Prob4008 {

    private static int N, max, min;
    private static int[] operator, numbers; // 연산자, 숫자

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 ////////////////////////////////////////////////////////////

            N = Integer.parseInt(br.readLine());

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            operator = new int[4]; // 연산자 + - * /
            numbers = new int[N]; // 계산할 숫자들

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) { // 연산자
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { // 계산할 수
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 실행 ///////////////////////////////////////////////////////////

            // 연산자의 개수는 N-1
            search(0, numbers[0]);

            sb.append("#" + testcase + " " + (max - min));
            System.out.println(sb);
        }
    }

    private static void search(int cnt, int result) {

        if (cnt == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] == 0)
                continue;

            operator[i]--;

            if (i == 0) { // +
                search(cnt + 1, result + numbers[cnt + 1]);
            } else if (i == 1) { // -
                search(cnt + 1, result - numbers[cnt + 1]);
            } else if (i == 2) { // *
                search(cnt + 1, result * numbers[cnt + 1]);
            } else if (i == 3) { // /
                search(cnt + 1, result / numbers[cnt + 1]);
            }

            operator[i]++;
        }
    }
}
