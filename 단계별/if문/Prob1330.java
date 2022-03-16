package 단계별.if문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob1330 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 128ms 14280KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer (br.readLine(), " ");

        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        if(a > b) {
            bw.write(">");
        } else if(a < b) {
            bw.write("<");
        } else {
            bw.write("==");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
