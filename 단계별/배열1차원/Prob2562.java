package 단계별.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.ArrayList;

public class Prob2562 {
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 144ms 15940KB
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = 0, count = 0;

        for(int i = 0; i < 9; i++) {

            int num = Integer.parseInt(br.readLine());

            if (num > max) {
                max = num;
                count = i+1;
            }

        }

        sb.append(max + "\n" + count); 

        // OPTION 2 : 156ms 16028KB

        int[] intArray = new int[9];

        for(int i = 0; i < 9; i++) {
            intArray[i] = Integer.parseInt(br.readLine());
        }

        int max2 = intArray[0], count2 = 1;

        for(int i = 1; i < 9; i++) {

            if (intArray[i] > max2) {
                max2 = intArray[i];
                count2 = i+1;
            }
        }
        
        sb.append(max2 + "\n" + count2);

        /** OPTION 3 : 다른 사람 코드
         * 
         * ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int max = list.get(0);

        for(int i = 1; i < 9; i++) {

            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        sb.append(max + "\n" + (list.indexOf(max)+1));
         */
             
        System.out.println(sb);

        br.close();
    }
    
}
