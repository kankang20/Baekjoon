
/**
* title  : 11399. ATM (Silver 4)
* time   : 132ms
* memory : 14420KB
*/

import java.io.*;
import java.util.*;

public class Prob11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] atm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            atm[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(atm);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += (atm[i] * (N - i)); 
        }

        System.out.println(answer);

    } // end main
}