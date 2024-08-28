
/**
* title  : 1926. 간단한 369게임 (D2)
* time   : 104ms
* memory : 18592kb
*/

import java.io.*;
 
public class Prob1926 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(checkNumber(String.valueOf(i))).append(" ");
        }

        System.out.println(sb);
    }

    public static String checkNumber(String number) {

        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            int check = Character.getNumericValue(number.charAt(i));
            if (check > 0 && check % 3 == 0) {
                count++;
            }
        }

        return (count == 0) ? number : printNumber(count);
    }

    public static String printNumber(int count) {

        String str = "";
        for (int i = 0; i < count; i++) {
            str += "-";
        }

        return str;
    }
}
