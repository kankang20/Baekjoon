
/**
* title  : 9342. 염색체 (Silver 3)
* time   : 108ms
* memory : 14176KB
*/

import java.io.*;

public class Prob9342 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String pattern = "^[ABCDEF]?A+F+C+[ABCDEF]?$";

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            String word = br.readLine();
            
            if (word.matches(pattern)) {
                sb.append("Infected!").append("\n");
            } else {
                sb.append("Good").append("\n");
            }
        }
        
        System.out.println(sb);
    }
}