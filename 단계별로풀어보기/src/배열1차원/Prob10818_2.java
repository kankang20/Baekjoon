package 배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob10818_2 {
    public static void main(String[] args) throws IOException {

        // OPTION 3 : 508ms 88312KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer (br.readLine(), " ");
        
        int min = 1000000, max = -1000000;
        
        for(int i = 0; i < count; i++) {

            int num = Integer.parseInt(st.nextToken());

            if (num > max){
                max = num;
            }

            if (num < min) {
                min = num;
            }

        }

        // OPTION 4 : 504ms 88016KB

        int min2 = Integer.parseInt(st.nextToken()), max2 = min;

        for(int i = 1; i < count; i++) {

            int num = Integer.parseInt(st.nextToken());

            max2 = Math.max(max, num);
            min2 = Math.min(min, num);

        }

        sb.append(min2 + " " + max2);
        
        System.out.println(sb);

        br.close();
    }
}
