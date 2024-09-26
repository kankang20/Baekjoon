
/**
 * title  : 1181. 단어 정렬 (Silver 5)
 * time   : 312ms
 * memory : 25960KB
 */

import java.io.*;
import java.util.*;

public class Prob1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        List<String> wordList = new ArrayList<>(wordSet);
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordList.size(); i++) {
            sb.append(wordList.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}