package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2675 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());

        // TO 다른 방법이 있을까? 우선 다른 맞힌사람 코드 보면 나랑 비슷한거 같은데

        // OPTION 1 : 124ms 14056KB

        for (int i = 0; i < repeat; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int count = Integer.parseInt(st.nextToken());
            char[] text = (st.nextToken()).toCharArray();

            for (int j = 0; j < text.length; j++) {
                for (int k = 0; k < count; k++) {
                    sb.append(text[j]);
                }
            }
            sb.append("\n");
        }

        // OPTION 2 : 124ms 14112KB

        for (int i = 0; i < repeat; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int count = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            for (int j = 0; j < text.length(); j++) {
                for (int k = 0; k < count; k++) {
                    sb.append(text.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    } 
}
