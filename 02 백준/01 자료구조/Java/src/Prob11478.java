
/**
* title  : 11478. 서로 다른 부분 문자열의 개수 (Silver 3)
* time   : 656ms
* memory : 226260KB
*/

import java.io.*;
import java.util.*;

public class Prob11478 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int length = word.length();
        
        HashSet<String> wordSet = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                wordSet.add(word.substring(i, j));
            }
        }

        System.out.println(wordSet.size());
    }
}