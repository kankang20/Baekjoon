package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳 찾기 148ms 15820KB

public class Prob10809_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] intArray = new int[26];
        String text = br.readLine();

        int num = 0;

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = -1;
        }

        for (int i = 0; i < text.length(); i++) {

            num = (int) text.charAt(i) - 'a';
            if (intArray[num] == -1) {
                intArray[num] = i;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i] + " ");
        }

        System.out.println(sb);
        br.close();

    }
}