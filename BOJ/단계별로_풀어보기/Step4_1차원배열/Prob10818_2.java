package BOJ.단계별로_풀어보기.Step4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1284ms 105616KB

public class Prob10818_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer (br.readLine(), " ");
    
        int[] IntArray = new int[count];

        for(int i = 0; i < count; i++) {
            IntArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(IntArray);

        sb.append(Integer.toString(IntArray[0]) + " " + Integer.toString(IntArray[count-1]));
        
        System.out.println(sb);

        br.close();
    }
}