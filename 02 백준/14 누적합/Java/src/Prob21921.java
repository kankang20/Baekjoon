
/**
* title  : 21921. 블로그 (Silver 3)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob21921 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] record = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            record[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = 0;
        int tempValue = 0;

        for (int i = 0; i < X; i++) {
            tempValue += record[i];
        }

        for (int i = X; i < N; i++) {
            
        }
    }
}
