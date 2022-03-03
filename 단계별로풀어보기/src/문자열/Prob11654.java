package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11654 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 120ms 14152KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int text = br.readLine().charAt(0);
        
        sb.append(text);
        System.out.println(sb);

        br.close();

        // OPTION 2 : 132ms 14088KB

        System.out.println((int)System.in.read());

        // OPTION 3 : 120ms 14168KB

        int input = System.in.read();

        System.out.println(input);
    }
}
