
/**
* title  : 6295. A+B (Level 1)
* time   : 121ms
* memory : 11.94MB
*/

import java.io.*;
import java.util.*;

public class Prob6295 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int A, B;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            System.out.printf("Case #%d: %d\n", (i+1), (A+B));
        }
    }
}
