
/**
* title  : 2751. 수 정렬하기 2 (Silver 5)
* time   : 1380ms
* memory : 108712KB
*/

import java.io.*;
import java.util.*;

public class Prob2751 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N  = Integer.parseInt(br.readLine());

        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);

        for (int i = 0; i < (N-1); i++) {
            sb.append(number[i]).append("\n");
        }
        
        sb.append(number[N-1]);

        System.out.println(sb);
    }
}
