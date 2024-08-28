
/**
* title  : 2056. 연월일 달력 (D1)
* time   : 109ms
* memory : 19112kb
*/

import java.io.*;
 
public class Prob2056 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            String date = br.readLine();
            int y = Integer.parseInt(date.substring(0, 4));
            int m = Integer.parseInt(date.substring(4, 6));
            int d = Integer.parseInt(date.substring(6, 8));
            
            String answer = "-1";
            if (1 <= m && m <= 12 && 1 <= d && d <= day[m]) {
                answer = (String.format("%04d", y) + "/" 
                            + String.format("%02d", m) + "/" 
                            + String.format("%02d", d));
            } 

            sb.append("#" + t + " ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
