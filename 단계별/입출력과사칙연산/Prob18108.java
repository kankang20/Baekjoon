package 단계별.입출력과사칙연산;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob18108 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 220ms 17716KB

        Scanner sc = new Scanner(System.in);
    
        int year  = sc.nextInt();
        System.out.println(year - 543);

        sc.close();

        // OPTION 2 : 124ms 14204KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        int a = Integer.parseInt(str);

        System.out.println(a - 543);

        // OPTION 3 : 132ms 14296KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write(Integer.toString(a - 543));
        bw.flush();
        bw.close();

        br.close(); 

    }
    
}
