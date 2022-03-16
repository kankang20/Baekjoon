package 단계별.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob8958 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        // OPTION 1 : 148ms 15920KB
    
        for (int i = 0; i < num; i++) {

            char[] charArray = br.readLine().toCharArray();
            int sum = 0;
            int total = 0;

            for (char j : charArray){
                if (j == 'O') {
                    sum++;
                } else {
                    sum = 0;
                }
                total += sum;
            }
            
            sb.append(total + "\n");
        }

        // OPTION 2 : 144ms 15784KB

        for (int i = 0; i < num; i++) {
            
            int sum = 0;
            int total = 0;

            for (char j : br.readLine().toCharArray()){
                if (j == 'O') {
                    sum++;
                } else {
                    sum = 0;
                }
                total += sum;
            }
            
            sb.append(total + "\n");
        }

        // OPTION 3 : 144ms 15836KB

        for (int i = 0; i < num; i++) {

            int sum = 0;
            int total = 0;

            for (byte j : br.readLine().getBytes()){
                if (j == 'O') {
                    sum++;
                } else {
                    sum = 0;
                }
                total += sum;
            }
            
            sb.append(total + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}
