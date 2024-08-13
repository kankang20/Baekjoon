
/**
* title  : 10814. 나이순 정렬 (Silver 5)
* time   : 752ms
* memory : 53032KB
*/

import java.io.*;
import java.util.*;

public class Prob10814 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] age = new int[N][2];
        String[] name = new String[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            age[i][0] = Integer.parseInt(st.nextToken());
            age[i][1] = i;
            name[i] = st.nextToken();
        }

        Arrays.sort(age, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });

        for (int i = 0; i < N; i++) {
            sb.append(age[i][0] + " " + name[age[i][1]]).append("\n");
        }

        System.out.println(sb);
    }
}
