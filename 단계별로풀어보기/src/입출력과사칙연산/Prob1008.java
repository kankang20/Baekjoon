package 입출력과사칙연산;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob1008 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 232ms 18020KB

        Scanner sc = new Scanner(System.in);
    
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        
        System.out.println(num1 / num2);

        sc.close();

        // OPTION 2 : 132ms 14364KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");

        double a = Double.parseDouble (st.nextToken());
        double b = Double.parseDouble (st.nextToken());

        System.out.println(a / b);

        // OPTION 3 : 124ms 14344KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        /** Double (숫자)를 String (문자열)으로 변환
         * String result = Double.toString(a_token + b_token);
         * String result = String.valueOf(a_token + b_token);
         */

        bw.write(Double.toString(a / b));
        bw.flush();
        bw.close();

        br.close(); 
    }
    
}
