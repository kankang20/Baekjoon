package BOJ.단계별로_풀어보기.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 세개 124ms 14332KB

public class Prob2480_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (arr[2] == arr[0]) {
            sum = 10000 + arr[2] * 1000;
        } else if ((arr[1] == arr[0]) || (arr[2] == arr[1])) {
            sum = 1000 + arr[1] * 100;
        } else {
            sum = arr[2] * 100;
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();

        br.close();

    }
}
