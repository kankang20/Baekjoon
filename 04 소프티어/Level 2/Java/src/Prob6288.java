
/**
* title  : 6288. 금고털이 (Level 2)
* time   : 1011ms
* memory : 82.20MB
*/

import java.io.*;
import java.util.*;

public class Prob6288 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<int[]> gold = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            gold.add(new int[] {M, P});
        }

        Collections.sort(gold, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int weight = W;
        int answer = 0;
        for (int[] g : gold) {

            if (g[0] <= weight) {
                weight -= g[0];
                answer += (g[0] * g[1]);
            } else {
                answer += (weight * g[1]);
                // weight -= g[0];
                break;
            }
        }

        System.out.println(answer);  
    }
    
}
