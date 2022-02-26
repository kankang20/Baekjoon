import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10818_1 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 1400ms 102748KB
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer (br.readLine(), " ");
    
        int[] IntArray = new int[count];

        for(int i = 0; i < count; i++) {
            IntArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(IntArray);
        
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        bw.write(Integer.toString(IntArray[0]) + " " + Integer.toString(IntArray[count-1]));
        bw.flush();
        bw.close();

        // OPTION 2 : 1284ms 105616KB

        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toString(IntArray[0]) + " " + Integer.toString(IntArray[count-1]));
        System.out.println(sb);

        br.close();
    }

}
