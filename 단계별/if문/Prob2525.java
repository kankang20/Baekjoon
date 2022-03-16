package 단계별.if문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob2525 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 128ms 14296KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        h += (m+t) / 60;
        m = (m+t) % 60;

        if (h >= 24) {
            h -= 24;
        } 

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        bw.write(Integer.toString(h) + " ");
        bw.write(Integer.toString(m));

        bw.flush();
        bw.close();

        br.close();
    }
}
