package 단계별.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob14681 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 120ms 14228KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y  = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        if ((x > 0) && (y > 0 )) {
            bw.write("1");
        } else if ((x < 0) && (y > 0)) {
            bw.write("2");
        } else if ((x < 0) && ( y < 0)) {
            bw.write("3");
        } else {
            bw.write("4");
        }

        bw.flush();
        bw.close();
        br.close();
    
    }
}
