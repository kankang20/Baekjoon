package BOJ.단계별로_풀어보기.Step5_함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 128ms 14504KB

public class Prob1065_2 {

    static boolean hansu(int number) {
        boolean check = true;

        if (number >= 100) {

            String text = String.valueOf(number);

            int i = 1;
            int diff1 = 0;
            int diff2 = 0;

            while(i < text.length() - 1) {
                
                diff1 = text.charAt(i-1) - text.charAt(i);
                diff2 = text.charAt(i) - text.charAt(i+1);

                if (diff1 != diff2) {
                    check = false;
                    break;
                } 

                i++;
            }
        }
        
        return check;
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        int range = Integer.parseInt(br.readLine());
    
        for (int i = 1; i < range+1; i++){
            if (hansu(i)) {
                count++;
            }
        }

        sb.append(count);

        System.out.println(sb);
        br.close();
        
    } 
}