package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11653 {
    public static void main(String[] args) throws IOException {
       
        // OPTION 1 : 180ms 15980KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int division = 2;

        if (N != 1){

            while(N > 1) {

                if (N % division == 0) {
                    sb.append(division + "\n");
                    N /= division;
                } else {
                    division++;
                }
            }
            
            System.out.println(sb);
        } 
        
        br.close(); 
    }
}
