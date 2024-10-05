
/**
* title  : 3273. 두 수의 합 (Silver 3)
* time   : 340ms
* memory : 27112KB
*/

import java.io.*;
import java.util.*;
 
public class Prob3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(number);

        int start = 0;
        int end = (N-1);

        int answer = 0;
        while (start < end) {

            int temp = number[start] + number[end];

            if (X < temp) {
                end--;
            } else {
                if (temp == X) {
                    answer++;
                }
                start++;
            }
        }

        System.out.println(answer);
    }
}