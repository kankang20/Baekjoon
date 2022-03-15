package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2941 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 124ms 14212KB
        // TO 다른 방법이 무조건 있을거니까 꼭 다른 사람 코드 확인해보기
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String text = br.readLine();
        int count = 0;
        int i = 0;

        while (i < text.length()-1) {

            char num = text.charAt(i);

            switch (num) {
                case 'c':
                    if (text.charAt(i+1) == '=' || text.charAt(i+1) == '-'){
                        count++;
                        i+=2;
                    } else {
                        count++;
                        i++;
                    } break;

                case 'd':
                    if (i < text.length()-2) {
                        if ((int)text.charAt(i+1) == 'z' && (int)text.charAt(i+2) == '=') {
                            count++;
                            i+=3;
                            break;
                        } 
                    } 

                    if (text.charAt(i+1) == '-') {
                        count++;
                        i+=2;
                    } else {
                        count++;
                        i++;
                    } break;

                case 'l':
                    if(text.charAt(i+1) == 'j') {
                        count++;
                        i+=2;
                    } else {
                        count++;
                        i++;
                    } break;

                case 'n':
                    if(text.charAt(i+1) == 'j') {
                        count++;
                        i+=2;
                    } else {
                        count++;
                        i++;
                    } break;

                case 's':
                    if(text.charAt(i+1) == '=') {
                        count++;
                        i+=2;
                    } else {
                        count++;
                        i++;
                    } break;

                case 'z':
                    if(text.charAt(i+1) == '=') {
                        count++;
                        i+=2;
                    } else {
                        count++;
                        i++;
                    } break;

                default:
                    count++;
                    i++;
                    break;
            }
        }

        if (i < text.length()) {
            count++;
        }

        sb.append(count);
        System.out.println(sb);
        br.close();
    }
}
