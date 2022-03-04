package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11720 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 124ms 14264KB
        // TO 또 다른 방법이 있지 않을까?
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;

        for (int i = 0; i < num; i++) {
            sum += str.charAt(i) - '0';
        }

        sb.append(sum);
        System.out.println(sb);

        br.close();
    }
}
