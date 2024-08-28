
/**
* title  : 1938. 아주 간단한 계산기 (D1)
* time   : 115ms
* memory : 16084kb
*/

import java.io.*;
import java.util.*;
 
public class Prob1938 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append(a + b).append("\n");
        sb.append(a - b).append("\n");
        sb.append(a * b).append("\n");
        sb.append(a / b).append("\n");

        System.out.println(sb);
    }
}
