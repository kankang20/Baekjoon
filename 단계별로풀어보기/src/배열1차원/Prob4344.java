package 배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob4344 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
    
        // OPTION 1 : 176ms 15564KB

        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int number = Integer.parseInt(st.nextToken());
            int[] intArray = new int[number];
            
            int sum = 0;
            float average = 0;
            int count = 0;

            for (int j = 0; j < number; j++) {
                intArray[j] = Integer.parseInt(st.nextToken());
                sum += intArray[j];
            }

            average = sum / (float)number;

            for (int j : intArray) {
                if (j > average) {
                    count++;
                }
            }

            sb.append(String.format("%.3f", count/(float)number*100) + "%\n");
        }

        // OPTION 2 : 176ms 15812KB

        for (int i = 0; i < num; i++) {

            String[] stringArray = br.readLine().split(" ");
            
            int sum = 0;
            int count = 0;

            for (int j = 1; j < stringArray.length; j++) {
                sum += Integer.parseInt(stringArray[j]);
            }

            float average = sum / Float.parseFloat(stringArray[0]);

            for (int j = 1; j < stringArray.length; j++) {
                if (Integer.parseInt(stringArray[j]) > average) {
                    count++;
                }
            }

            sb.append(String.format("%.3f", count/Float.parseFloat(stringArray[0])*100) + "%\n");
        }

        System.out.println(sb);

        br.close();
    }
}
