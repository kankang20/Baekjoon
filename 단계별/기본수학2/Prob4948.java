package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob4948 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // OPTION 1 : 시간초과
        
        int input = 1;
        int count;

        while (input != 0) {

            input = Integer.parseInt(br.readLine());
            count = 0;

            for (int i = input+1; i < 2*input; i++) {

                if (i >= 2) {
    
                    boolean check = true;
    
                    for (int j = 2; j < i; j++) {
                        
                        if (i % j == 0) {
                            check = false;
                            break;
                        }
                    }
    
                    if (check) {
                        count++;
                    }
                }
            }

            sb.append(count + "\n");
        }
        
        System.out.println(sb);
        br.close(); 
    }
}
