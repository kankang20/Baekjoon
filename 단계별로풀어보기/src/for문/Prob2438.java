package for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2438 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 128ms 14200KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 1; i <= num; i++) {
            
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }

            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
