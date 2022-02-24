import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob10952 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 128ms 14208KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        
        while (true) {
            
            StringTokenizer st = new StringTokenizer (br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a==0 && b==0) {
                break;
            }

            bw.write(String.valueOf(a+b));
            bw.newLine();
        }
        
        bw.flush();

        bw.close();
        br.close();
    }
}
