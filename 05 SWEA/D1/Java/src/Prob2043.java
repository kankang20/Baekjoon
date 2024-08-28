
/**
* title  : 2043. 서랍의 비밀번호 (D1)
* time   : 109ms
* memory : 18616kb
*/

import java.io.*;
import java.util.*;
 
public class Prob2043 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()) + 1);
    }
}
