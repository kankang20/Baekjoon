package 정렬;

import java.io.*;
import java.util.*;

public class Prob11931 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Integer[] number = new Integer[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number, Collections.reverseOrder());

        for(int i = 0; i < (N-1); i++) {
            sb.append(number[i]).append("\n");
        }

        sb.append(number[N-1]);

        System.out.println(sb);
    }
}
