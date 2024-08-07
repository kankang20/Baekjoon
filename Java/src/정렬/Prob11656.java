package 정렬;

import java.io.*;
import java.util.*;

public class Prob11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        int length = word.length();

        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            answer[i] = word.substring(i, length);
        }

        Arrays.sort(answer);

        for (String ans : answer) {
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
