package 단계별.if문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob2884 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 136ms 14492KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer (br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a==0) {
            a = 24;
        }

        int sum = (60*a + b) - 45;

        int hour = sum / 60;
        int minute = sum % 60;

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        if(hour==24) {
            hour = 0;
        }

        bw.write(Integer.toString(hour) + " ");
        bw.write(Integer.toString(minute));

        // OPTION 2 : 140ms 14300KB

        if (a==0) {
            if (b >= 45) {
                b -= 45;
            } else {
                a = 23;
                b += 15;
            }
        } else {
            if (b >= 45) {
                b -= 45;
            } else {
                a -= 1;
                b += 15;
            }
        }

        bw.write(Integer.toString(a) + " ");
        bw.write(Integer.toString(b));

        bw.flush();
        bw.close();

        br.close();

    }
}
