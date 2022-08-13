package JUNGOL.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1341 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if (s <= e) {
            for (int i = s; i <= e; i++) {
                for (int j = 1; j < 10; j++) {
                    System.out.printf("%d * %d = %2d   ", i, j, (i*j));
                    if(j%3==0) System.out.println();
                }
                System.out.println();
            }
        } else {
            for (int i = s; i >=e; i--) {
                for (int j = 1; j < 10; j++) {
                    System.out.printf("%d * %d = %2d   ", i, j, (i*j));
                    if(j%3==0) System.out.println();
                }
                System.out.println();
            }
        }

    }
}
