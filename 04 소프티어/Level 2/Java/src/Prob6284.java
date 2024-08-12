
/**
* title  : 6284. 바이러스 (Level 2)
* time   : 76ms
* memory : 10.29MB
*/

import java.io.*;
import java.util.*;

public class Prob6284 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        System.out.println(K * spread(P, N) % 1000000007);
    }

    public static long spread(int p, long n) {

        if (n == 1) {
            return p;
        }

        long temp = spread(p, n/2);

        if (n % 2 == 0) {
            return temp * temp % 1000000007;
        } else {
            return (temp * temp % 1000000007) * p % 1000000007;
        }
    }
}
