
/**
* title  : 5648. 역원소 정렬 (Silver 5)
* time   : 284ms
* memory : 21648KB
*/

import java.io.*;
import java.util.*;

public class Prob5648 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        String[] numbers = new String[N];

        int idx = 0;
        while (true) {

            while (st.hasMoreTokens()) {
                numbers[idx] = st.nextToken();
                idx++;
            }

            if (idx == N) {
                break;
            }

            st = new StringTokenizer(br.readLine());
        }

        Long[] answer = new Long[N];

        for (int i = 0; i < N; i++) {

            String temp = "";
            String number = numbers[i];

            for (int j = number.length() - 1; j >= 0 ; j--) {
                temp += number.charAt(j);
            }

            answer[i] = Long.valueOf(temp);
        }

        Arrays.sort(answer);

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }
}