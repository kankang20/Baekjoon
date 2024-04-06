package 문자열;

import java.io.*;

public class Prob1316 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for (int n = 0; n < N; n++) {

            String word = br.readLine();

            boolean[] selected = new boolean[26];
            int check_word = 0;
            boolean flag = true;
            
            for (int i = 0; i < word.length(); i++) {

                int temp = word.charAt(i);

                if (check_word != temp) {

                    if (selected[temp - 'a']) {
                        flag = false;
                        break;
                    } else {
                        selected[temp - 'a'] = true;
                        check_word = temp;
                    }
                } else {
                    continue;
                }
            }

            if (flag) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
