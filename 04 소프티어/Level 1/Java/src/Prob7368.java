
/**
* title  : 7368. 위험한 효도 (Level 1)
* time   : 64ms
* memory : 10.22MB
*/

import java.io.*;
import java.util.*;

public class Prob7368 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int answer = 0;

        answer += ((D / A) * (A+B)) + ((D % A) == 0 ? -B : (D % A));
        answer += ((D / B) * (A+B)) + ((D % B) == 0 ? -A : (D % B));

        System.out.println(answer);
    }
}

