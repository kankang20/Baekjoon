
/**
* title  : 20436. ZOAC 3 (Silver 4)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob20436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, int[]> wordMap = makeWordMap();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] Lpos = wordMap.get(st.nextToken().charAt(0));
        int[] Rpos = wordMap.get(st.nextToken().charAt(0));

        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {

            int[] pos = wordMap.get(word.charAt(i));

            if (pos[0] == 2) {
                
            } else {

            }
        }
        

    }

    public static HashMap<Character, int[]> makeWordMap() {

        HashMap<Character, int[]> temp = new HashMap<>();

        // 2 왼쪽 3 오른쪽
        temp.put('q', new int[] {2, 0, 0});
        temp.put('w', new int[] {2, 0, 1});
        temp.put('e', new int[] {2, 0, 2});
        temp.put('r', new int[] {2, 0, 3});
        temp.put('t', new int[] {2, 0, 4});
        temp.put('a', new int[] {2, 1, 0});
        temp.put('s', new int[] {2, 1, 1});
        temp.put('d', new int[] {2, 1, 2});
        temp.put('f', new int[] {2, 1, 3});
        temp.put('g', new int[] {2, 1, 4});
        temp.put('z', new int[] {2, 2, 0});
        temp.put('x', new int[] {2, 2, 1});
        temp.put('c', new int[] {2, 2, 2});
        temp.put('v', new int[] {2, 2, 3});

        temp.put('y', new int[] {3, 0, 5});
        temp.put('u', new int[] {3, 0, 6});
        temp.put('i', new int[] {3, 0, 7});
        temp.put('o', new int[] {3, 0, 8});
        temp.put('p', new int[] {3, 0, 9});
        temp.put('h', new int[] {3, 1, 5});
        temp.put('j', new int[] {3, 1, 6});
        temp.put('k', new int[] {3, 1, 7});
        temp.put('l', new int[] {3, 1, 8});
        temp.put('b', new int[] {3, 2, 4});
        temp.put('n', new int[] {3, 2, 5});
        temp.put('m', new int[] {3, 2, 6});

        return temp;
    }
}