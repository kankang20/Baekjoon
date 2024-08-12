
/**
* title  : 6253. 주행거리 비교하기 (Level 1)
* time   : 66ms
* memory : 10.11MB
*/

import java.io.*;
import java.util.*;

public class Prob6253 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A == B) {
            System.out.println("same");
        } else if (A < B) {
            System.out.println("B");
        } else if (A > B) {
            System.out.println("A");
        }
        
    }
    
}

