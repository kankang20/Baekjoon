
/**
* title  : 2025. N줄덧셈 (D1)
* time   : 104ms
* memory : 16076kb
*/

import java.io.*;
 
public class Prob2025 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        if (N % 2 == 0) {
            answer = (1 + N) * (N / 2);
        } else {
            answer = N* ((N - 1) / 2) + N;
        }

        System.out.println(answer);
    }
}
