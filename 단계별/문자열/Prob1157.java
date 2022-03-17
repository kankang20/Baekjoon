package 단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Prob1157 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 404ms 36900KB
        // TO 시간이 너무 걸린다.. Map말고 다른 방법이 있을까? 아니면 Map을 좀 효율적으로 쓸수는 없을까
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
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
            if(map.get(key) > max_value) {
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
