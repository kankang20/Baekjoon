
/**
* title  : 20920. 영단어 암기는 괴로워 (Silver 3)
* time   : 684ms
* memory : 37712KB
*/

import java.io.*;
import java.util.*;

public class Prob20920 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (M <= word.length()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(wordMap.keySet());
        
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (wordMap.get(o1).equals(wordMap.get(o2))) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return wordMap.get(o2).compareTo(wordMap.get(o1));
            }   
        });

        for (String key : keySet) {
            sb.append(key).append("\n");
        }

        System.out.println(sb);
    }
}
