
/**
* title  : 1936. 1대1 가위바위보 (D1)
* time   : 102ms
* memory : 16076kb
*/

import java.io.*;
import java.util.*;
 
public class Prob1936 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        String answer;

        if (Math.abs(a - b) == 1) {
            answer = (a < b ? "B" : "A");
        } else {
            answer = (a == 3 ? "B" : "A");
        }

        System.out.println(answer);
    }
}
