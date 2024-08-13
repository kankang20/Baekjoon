
/**
* title  : 15688. 수 정렬하기 5 (Silver 5)
* time   : 20568ms
* memory : 108028KB
*/

import java.io.*;
import java.util.*;

public class Prob15688 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);

        for(int i = 0; i < N; i++) {
            sb.append(number[i]).append("\n");
        }

        System.out.println(sb);
    }
}
