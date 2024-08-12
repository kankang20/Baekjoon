
/**
* title  : 6268. [21년 재직자 대회 예선] 전광판 (Level 2)
* time   : 239ms
* memory : 21.47MB
*/

import java.io.*;
import java.util.*;

public class Prob6268 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        HashMap<Character, int[]> board = new HashMap<>();
        board.put('0', new int[] {1, 1, 0, 1, 1, 1, 1});
        board.put('1', new int[] {0, 0, 0, 1, 0, 0, 1});
        board.put('2', new int[] {1, 0, 1, 1, 1, 1, 0});
        board.put('3', new int[] {1, 0, 1, 1, 0, 1, 1});
        board.put('4', new int[] {0, 1, 1, 1, 0, 0, 1});
        board.put('5', new int[] {1, 1, 1, 0, 0, 1, 1});
        board.put('6', new int[] {1, 1, 1, 0, 1, 1, 1});
        board.put('7', new int[] {1, 1, 0, 1, 0, 0, 1});
        board.put('8', new int[] {1, 1, 1, 1, 1, 1, 1});
        board.put('9', new int[] {1, 1, 1, 1, 0, 1, 1});
        board.put(' ', new int[] {0, 0, 0, 0, 0, 0, 0});
        
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String A = String.format("%5d", Integer.parseInt(st.nextToken()));
            String B = String.format("%5d", Integer.parseInt(st.nextToken()));

            int answer = 0;
            for (int i = 0; i < 5; i++) {
                answer += check(board.get(A.charAt(i)), board.get(B.charAt(i)));
            }

            System.out.println(answer);
        }
    }

    public static int check(int[] a, int[] b) {
        int count = 0;
        for (int i = 0 ; i < 7; i++) {
            if (a[i] != b[i]) {
                count += 1;
            }
        }
        return count;
    }
}
