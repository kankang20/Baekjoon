
/**
* title  : 6254. 근무 시간 (Level 1)
* time   : 121ms
* memory : 11.94MB
*/

import java.io.*;
import java.util.*;
 
public class Prob6254 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String[] t1 = st.nextToken().split(":");
            String[] t2 = st.nextToken().split(":");

            answer += ((Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1])) 
                  - (Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1])));
        }

        System.out.println(answer);
    }
}
