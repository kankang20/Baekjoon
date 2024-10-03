
/**
* title  : 6550. 부분 문자열 (Silver 5)
* time   : 152ms
* memory : 16308KB
*/

import java.io.*;
import java.util.*;

public class Prob6550 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word;
        StringTokenizer st;
        while (true) {

            word = br.readLine();
            if (word == null) break;

            st = new StringTokenizer(word);

            String s = st.nextToken();
            String t = st.nextToken();

            int sPos = 0;
            int sLength = s.length();

            String answer = "No";
            for (int i = 0; i < t.length(); i++) {

                if (s.charAt(sPos) == t.charAt(i)) {
                    sPos++;
                }

                if (sPos == sLength) {
                    answer = "Yes";
                    break;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}