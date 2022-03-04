package if문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob9498 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 128ms 14260KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        switch (num/10) {
            case 10:
            case 9:
                bw.write("A");
                break;
            case 8:
                bw.write("B");
                break;
            case 7:
                bw.write("C");
                break;
            case 6:
                bw.write("D");
                break;
            default:
                bw.write("F");
                break;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
