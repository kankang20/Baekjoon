package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob10250 {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            String width = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            // OPTION 1 : 132ms 14288KB

            int x = number / height;
            int y = number % height;

            if (y == 0) {
                y = height;
            } else { 
                x++; 
            }
    
            System.out.println(y*100 + x);

            // OPTION 2 : 140ms 14316KB

            // if (number % height == 0) {
            //     System.out.println(height*100 + (number/height));
            // } else {
            //     System.out.println((number%height)*100 + (number/height) + 1);
            // }
        }
        br.close();
    }
}
