package 단계별.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2742 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 236ms 20632KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
    
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        for (int i = 0; i < num; i++) {

            bw.write(Integer.toString(num-i));
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
