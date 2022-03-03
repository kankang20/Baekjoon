import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2753 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 128ms 14424KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }

        // OPTION 2 : 124ms 14292KB

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
