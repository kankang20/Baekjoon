
/**
* title  : 2046. 스탬프 찍기 (D1)
* time   : 99ms
* memory : 19188kb
*/

import java.io.*;
 
public class Prob2046 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        String answer = "";
        for (int i = 0; i < N; i++) {
            answer += "#";
        }

        System.out.println(answer);
    }
}
