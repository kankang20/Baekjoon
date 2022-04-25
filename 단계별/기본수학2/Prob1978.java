package 단계별.기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1978 {

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int count = 0;

        // OPTION 1 : 124ms 14338KB

        for (int i = 0; i < number; i++) {

            int num = Integer.parseInt(str.nextToken());

            if (num >= 2) {

                boolean check = true;

                for (int j = 2; j < num; j++) {
                    
                    if (num % j == 0) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    count++;
                }
            }
        }

        // OPTION 2 : 124ms 14224KB

        for (int i = 0; i < number; i++) {

            int num = Integer.parseInt(str.nextToken());

            if (num == 1) continue; // 다음 반복문으로

            boolean check = true;

            for (int j = 2; j < num; j++) {
                    
                if (num % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;
            }
            
        }

        // OPTION 3 : 120ms 14192KB

        for (int i = 0; i < number; i++) {

            int num = Integer.parseInt(str.nextToken());

            if (num == 1) continue; 

            boolean check = true;

            for (int j = 2; j <= Math.sqrt(num); j++) {
                    
                if (num % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;
            }
            
        }

        sb.append(count);
        
        System.out.println(sb);
        br.close(); 
    }
    
}
