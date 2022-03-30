package 단계별.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2739 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 160ms 16368KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        String num = br.readLine();
        int number = Integer.parseInt(num);

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 1; i < 10; i++) {
            
            bw.write(num + " * " + Integer.toString(i) + " = " + Integer.toString(number*i));
            bw.newLine();    
        }

        bw.flush();
        bw.close();

        br.close();
    }
}
