
/**
* title  : 2063. 중간값 찾기 (D1)
* time   : 102ms
* memory : 19400kb
*/

import java.io.*;
import java.util.*;
 
public class Prob2063 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        System.out.println(number[N/2]);
    }
}
