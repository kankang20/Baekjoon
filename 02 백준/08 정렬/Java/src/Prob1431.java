
/**
* title  : 1431. 시리얼 번호 (Silver 3)
* time   : 104ms
* memory : 14276KB
*/

import java.io.*;
import java.util.*;

public class Prob1431 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                
                if (o1.length() == o2.length()) {
                    
                    int c1 = calculate_number(o1);
                    int c2 = calculate_number(o2);

                    if (c1 == c2) {
                        return o1.compareTo(o2);
                    }

                    return c1 - c2;
                }

                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(words[i]).append("\n");
        }

        System.out.println(sb);
    }
    
    public static int calculate_number(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if(Character.isDigit(word.charAt(i))) {
                count += (word.charAt(i) - '0');
            }
        }
        return count;
    }
}
