
/**
* title  : 7695. [한양대 HCPC 2023] Tren del Fin del Mundo (Level 1)
* time   : 102ms
* memory : 12.09MB
*/

import java.io.*;
import java.util.*;

public class Prob7695 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ansx = 0, ansy = 1001;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (y < ansy) {
                ansx = x;
                ansy = y;
            }
        }

        System.out.printf("%d %d", ansx, ansy);
    }
    
}
