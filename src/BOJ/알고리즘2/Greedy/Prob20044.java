package BOJ.알고리즘2.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob20044 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int people = 2*n;
        int[] ability = new int[people];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < people; i++) {
            ability[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ability);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, ability[i] + ability[people-i-1]);
        }

        System.out.println(answer);

    } // end main


}
