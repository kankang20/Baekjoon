import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob1000 {
    
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 208ms 17724KB
        
        Scanner sc = new Scanner(System.in);
    
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        System.out.println(num1 + num2);

        sc.close();

        // OPTION 2 & 3 & 4

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        // OPTION 2 : 120ms 14204KB

        StringTokenizer st = new StringTokenizer (str, " ");

        int a_token = Integer.parseInt (st.nextToken());
        int b_token = Integer.parseInt (st.nextToken());

        System.out.println(a_token + b_token);

        // OPTION 3 : 124ms 14236KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        /** int (숫자)를 String (문자열)으로 변환
         * String result = Integer.toString(a_token + b_token);
         * String result = String.valueOf(a_token + b_token);
         */

        bw.write(Integer.toString(a_token + b_token));
        bw.flush();
        bw.close();
        
        br.close();

        // OPTION 4 : 136ms 14260KB

        String[] strSplit = str.split(" ");

        int a_split = Integer.parseInt (strSplit[0]);
        int b_split = Integer.parseInt (strSplit[1]);

        System.out.println(a_split + b_split);
    }
}
