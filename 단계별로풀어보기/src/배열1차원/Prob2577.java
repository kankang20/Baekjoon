package 배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2577 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = 1;
        int[] intArray = new int[10];

        for(int i = 0; i < 3; i++) {
            number = number * Integer.parseInt(br.readLine());    
        }

        // OPTION 1 : 152ms 14620KB

        while(number > 0) {
            intArray[number%10]++;
            number /= 10;
        }

        // OPTION 2 : 136ms 14572KB

        String str = Integer.toString(number);

        for(int i = 0; i < str.length(); i++) {
            intArray[str.charAt(i) - '0']++;        // charAt은 문자열로서 숫자를 반환, 이를 int로 바꾸게 되면 아스키코드 값으로 변환됨 
                                                    // 아스키 코드 값을 원래 숫자로서 바꾸기 위해 아스키코드 값 48인 '0'을 빼줌 EX. '1' = 49, '2' = 50    
        }

        for(int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i] + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}
