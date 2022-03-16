package 단계별.입출력과사칙연산;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob10998 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 216ms 17700KB

        Scanner sc = new Scanner(System.in);
    
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        System.out.println(num1 * num2);

        sc.close();

        // OPTION 2 : 124ms 14320KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");

        int a = Integer.parseInt (st.nextToken());
        int b = Integer.parseInt (st.nextToken());

        System.out.println(a * b);

        // OPTION 3 : 124ms 14328KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write(Integer.toString(a * b));
        bw.flush();
        bw.close();

        br.close(); 
    }
}
