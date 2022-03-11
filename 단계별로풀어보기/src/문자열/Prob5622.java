package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob5622 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int count = 0;

        // OPTION 1 : 132ms 14152KB
        
        for (int i = 0; i < str.length(); i++) {

            String text = String.valueOf(str.charAt(i));

            if ("ABC".contains(text)) {
                count += 3;
            } else if ("DEF".contains(text)) {
                count += 4;
            } else if ("GHI".contains(text)) {
                count += 5;
            } else if ("JKL".contains(text)) {
                count += 6;
            } else if ("MNO".contains(text)) {
                count += 7;
            } else if ("PQRS".contains(text)) {
                count += 8;
            } else if ("TUV".contains(text)) {
                count += 9;
            } else if ("WXYZ".contains(text)) {
                count += 10;
            }
        }

        // OPTION 2 : 140ms 14276KB

        for (int i = 0; i < str.length(); i++) {

            int text = str.charAt(i);

            if (text < 68) {
                count += 3;
            } else if (text < 71) {
                count += 4;
            } else if (text < 74) {
                count += 5;
            } else if (text < 77) {
                count += 6;
            } else if (text < 80) {
                count += 7;
            } else if (text < 84) {
                count += 8;
            } else if (text < 87) {
                count += 9;
            } else if (text < 91) {
                count += 10;
            }
        }

        sb.append(count);
        System.out.println(sb); 
        br.close();
    } 
}
