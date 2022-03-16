package 단계별.함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1065 {

    // OPTION 2 : 128ms 14504KB
    // TO 함수 내에서 다 해결이 가능하게 짤수도 있을거 같아
    // TO 이거말고 또 다른 방법이 있을까?

    static boolean hansu(int number) {
        boolean check = true;

        if (number >= 100) {             // if (number / 100 != 0) // OPTION 1 : 144ms 14280KB 

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
