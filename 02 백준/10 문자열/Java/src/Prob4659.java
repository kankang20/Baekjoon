
/**
* title  : 4659. 비밀번호 발음하기 (Silver 5)
* time   : 88ms
* memory : 14008KB
*/

import java.io.*;

public class Prob4659 {

    private static String vowels = "aeiou";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String word = br.readLine();
            char[] wordArray = word.toCharArray();

            if (word.equals("end")) {
                break;
            }

            sb.append("<").append(word).append("> is ");

            if (checkOne(wordArray) && checkTwo(wordArray) && checkThree(wordArray)) {
                sb.append("acceptable.").append("\n");
            } else {
                sb.append("not acceptable.").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean checkOne(char[] word) {

        for (int i = 0; i < word.length; i++) {
            if (vowels.contains(String.valueOf(word[i]))) {
                return true;
            } 
        }

        return false;
    }

    public static boolean checkTwo(char[] word) {

        int vCount = 0;
        int eCount = 0;

        for (int i = 0; i < word.length; i++) {

            if (vowels.contains(String.valueOf(word[i]))) {
                vCount++;
                eCount = 0;
            } else {
                eCount++;
                vCount = 0;
            }

            if (vCount == 3 || eCount == 3) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkThree(char[] word) {

        for (int i = 1; i < word.length; i++) {

            if (word[i-1] == word[i]) {
                if (word[i] == 'e' || word[i] == 'o') {
                    continue;
                }
                return false;
            }
        }

        return true;
    }
}