
/**
 * title  : 1316. 그룹 단어 체커 (Silver 5)
 * time   : 124ms
 * memory : 14176KB
 */

 import java.io.*;
 import java.util.*;
 
 public class Prob1316 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for (int n = 0; n < N; n++) {

            String word = br.readLine();
            int length = word.length();

            Set<Character> check = new HashSet<>();

            int idx = 0;
            boolean flag = true;
            while (idx < length) {

                char temp = word.charAt(idx);

                if (check.contains(temp)) {
                    flag = false;
                    break;
                }

                check.add(temp);
                while (idx < length && word.charAt(idx) == temp) {
                    idx++;
                }
            }

            if (flag) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
