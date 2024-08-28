
/**
* title  : 2058. 자릿수 더하기 (D1)
* time   : 139ms
* memory : 17136kb
*/

import java.io.*;
 
public class Prob2058 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            answer += (N.charAt(i) - '0');
        }

        System.out.println(answer);
    }
}
