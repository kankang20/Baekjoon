package 단계별.입출력과사칙연산;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob10926 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 204ms 17708KB

        Scanner sc = new Scanner(System.in);
    
        String name  = sc.next();
        System.out.println(name + "??!");

        sc.close();

        // OPTION 2 : 128ms 14348KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(str + "??!");

        // OPTION 3 : 128ms 14316KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write(str + "??!");
        bw.flush();
        bw.close();

        br.close(); 
    }
    
}
