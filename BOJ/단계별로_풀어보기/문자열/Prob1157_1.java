package BOJ.단계별로_풀어보기.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 단어 공부 388ms 36880KB

public class Prob1157_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();

        String text = (br.readLine()).toUpperCase();
        Character max_key = ' ';
        int max_value = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        for (Character key : map.keySet()) {
            if (map.get(key) > max_value) {
                max_value = map.get(key);
                max_key = key;
            }
        }

        for (Character key : map.keySet()) {
            if (map.get(key) == max_value && key != max_key) {
                max_key = "?".charAt(0);
            }
        }

        sb.append(max_key);

        System.out.println(sb);
        br.close();
    }
}