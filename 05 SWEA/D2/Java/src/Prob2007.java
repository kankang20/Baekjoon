
/**
* title  : 2007. 패턴 마디의 길이 (D2)
* time   : 101ms
* memory : 18448kb
*/

import java.io.*;
 
public class Prob2007 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            String pattern = br.readLine();
            int pos = 0;

            while (++pos < 10) {

                while (pattern.charAt(0) != pattern.charAt(pos)) {
                    pos++;
                }

                if (pattern.substring(0, pos).equals(pattern.substring(pos, pos * 2))) {
                    break;
                }
            }

            sb.append("#" + tc + " ").append(pos).append("\n");
        }

        System.out.println(sb);
    }
}