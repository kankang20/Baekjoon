package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2908 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // OPTION 1 : 144ms 14144KB
        
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        int number11 = 0;
        int number12 = 0;

        int i = 2;

        while (i >= 0) {
            number11 += (num1.charAt(i) - '0') * Math.pow(10, i);
            number12 += (num2.charAt(i) - '0') * Math.pow(10, i);
            i--;
        }

        sb.append(number11 > number12 ? number11 : number12);

        // OPTION 2 : 132ms 14224KB

        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());

        int number21 = Integer.parseInt(sb1.reverse().toString());
        int number22 = Integer.parseInt(sb2.reverse().toString());

        sb.append(number21 > number22 ? number21 : number22);

        System.out.println(sb); 
        br.close();
    } 
}
