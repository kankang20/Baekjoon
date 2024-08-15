
/**
* title  : 5648. 역원소 정렬 (Silver 5)
* time   : 208ms
* memory : 19748KB
*/

import java.io.*;
import java.util.*;

public class Prob5648 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Long[] answer = new Long[N];

        int idx = 0;
        while (true) {

            while (st.hasMoreTokens()) {
                StringBuilder temp = new StringBuilder(st.nextToken());
                answer[idx] = Long.valueOf(String.valueOf(temp.reverse()));
                idx++;
            }

            if (idx == N) {
                break;
            }

            st = new StringTokenizer(br.readLine());
        }

        Arrays.sort(answer);

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }
}