import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob2588 {
    public static void main(String[] args) throws IOException {
        
        // OPTION 1 : 212ms 17680KB

        Scanner sc = new Scanner(System.in);
    
        int num1  = sc.nextInt();
        int num2  = sc.nextInt();

        int one = num2 % 10;
        int two = (num2-one) % 100;
        int three = num2-one-two;

        System.out.println(num1*one);
        System.out.println(num1*(two/10));
        System.out.println(num1*(three/100));
        System.out.println(num1*num2);

        sc.close();

        // OPTION 2 : 128ms 14252KB

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int a1 = Integer.parseInt(br.readLine());    // 한 행씩 입력되는 숫자를 받아옴
        int b1 = Integer.parseInt(br.readLine());

        System.out.println(a1*(b1%10));
        System.out.println(a1*(b1%100/10));
        System.out.println(a1*(b1/100));
        System.out.println(a1*b1);

        // OPTION 3 : 120ms 14188KB

        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write(Integer.toString(a1*(b1%10)));
        bw.newLine();
        bw.write(Integer.toString(a1*(b1%100/10)));
        bw.newLine();
        bw.write(Integer.toString(a1*(b1/100)));
        bw.newLine();
        bw.write(Integer.toString(a1*b1));
        bw.flush();
        bw.close();

        br.close(); 

        // OPTION 4 : 124ms 14156KB
        
        bw.write(Integer.toString(a1*(b1%10)) + "\n");
        bw.write(Integer.toString(a1*(b1%100/10)) + "\n");
        bw.write(Integer.toString(a1*(b1/100)) + "\n");
        bw.write(Integer.toString(a1*b1));
        bw.flush();
        bw.close();

        br.close(); 
        
        // 한 문자씩 읽어오는 방법도 있음 

        /** 
         * charAt(0)
         * 문자열의 인덱스 위치에 있는 문자의 아스키코드 값을 반환
         * 
         * toCharArray()
         * 문자열을 char 배열 형태로 반환
         */

        // OPTION 5 : 124ms 14136KB

        int a2 = Integer.parseInt(br.readLine());    // 한 행씩 입력되는 숫자를 받아옴
        String b2 = br.readLine();

        bw.write(Integer.toString(a2 * (b2.charAt(2)-'0')));    // -'0'을 통해 아스키코트를 숫자로
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2.charAt(1)-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2.charAt(0)-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * Integer.parseInt(b2)));
        bw.flush();
        bw.close();

        br.close();

        // OPTION 6 : 120ms 14108KB

        char[] b2_char = b2.toCharArray();

        bw.write(Integer.toString(a2 * (b2_char[2]-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2_char[1]-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * (b2_char[0]-'0')));
        bw.newLine();
        bw.write(Integer.toString(a2 * Integer.parseInt(b2)));
        bw.flush();
        bw.close();

        br.close();
    }
}
