
/**
* title  : 4659. 비밀번호 발음하기 (Silver 5)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob4659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String word = br.readLine();
            char[] wordArray = word.toCharArray();

            if (word == "end") {
                break;
            }

            sb.append("<").append(word).append("> is ");

            if (checkOne(wordArray) && checkTwo(word) && checkThree(word)) {
                sb.append("acceptable.").append("\n");
            } else {
                sb.append("not acceptable.").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean checkOne(char[] word) {

        String check = "aeiou";

        for (int i = 0; i < word.length; i++) {
            if (check.contains(String.valueOf(word[i]))) {
                return true;
            } 
        }

        return false;
    }

    public static boolean checkTwo(String word) {
        return false;
    }

    public static boolean checkThree(String word) {
        return false;
    }
}