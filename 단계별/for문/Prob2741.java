package 단계별.for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2741 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 248ms 20632KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
    
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 1; i <= num; i++) {

            bw.write(Integer.toString(i));
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
