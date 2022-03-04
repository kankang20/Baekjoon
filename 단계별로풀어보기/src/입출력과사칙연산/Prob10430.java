package 입출력과사칙연산;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob10430 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 220ms 17692KB

        Scanner sc = new Scanner(System.in);
    
        int A1  = sc.nextInt();
        int B1  = sc.nextInt();
        int C1  = sc.nextInt();

        System.out.println((A1+B1)%C1);
        System.out.println(((A1%C1)+(B1%C1))%C1);
        System.out.println((A1*B1)%C1);
        System.out.println(((A1%C1)*(B1%C1))%C1);

        sc.close();

        // OPTION 2 : 124ms 14236KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer (str, " ");
        
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        System.out.println((A2+B2)%C2);
        System.out.println(((A2%C2)+(B2%C2))%C2);
        System.out.println((A2*B2)%C2);
        System.out.println(((A2%C2)*(B2%C2))%C2);

        // OPTION 3 : 136ms 14292KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write(Integer.toString((A2+B2)%C2));
        bw.newLine();
        bw.write(Integer.toString(((A2%C2)+(B2%C2))%C2));
        bw.newLine();
        bw.write(Integer.toString((A2*B2)%C2));
        bw.newLine();
        bw.write(Integer.toString(((A2%C2)*(B2%C2))%C2));
        bw.flush();
        bw.close();

        br.close();  
    }
    
}
