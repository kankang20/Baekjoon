package 단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1316 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 156ms 16092KB
        // TO 다른 코드 확인 필요 무조건.. 다 나보다 번뜩이는 아이디어를 가지고 있쥐 

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < num; i++) {
            
            String text = br.readLine();
            
            boolean voca = true;
            String str = "";
            char previous = ' ';
           
            for (int j = 0; j < text.length(); j++) {

                char temp = text.charAt(j);

                if ((previous != temp) && (str.contains(String.valueOf(temp)))) {
                    voca = false;
                    break;
                }

                str += String.valueOf(temp);
                previous = temp;
            }

            if (voca == true) {
                count++;   
            }
            
        }

        sb.append(count + "\n");
        
        System.out.println(sb);
        br.close();
    }
}
