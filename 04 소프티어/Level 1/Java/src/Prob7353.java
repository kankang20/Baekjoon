
/**
* title  : 7353. 나무 심기 (Level 1)
* time   : 69ms
* memory : 10.34MB
*/

import java.io.*;
import java.util.*;

public class Prob7353 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        System.out.println(Math.max(tree[0]*tree[1], tree[N-1]*tree[N-2]));
    }
    
}
