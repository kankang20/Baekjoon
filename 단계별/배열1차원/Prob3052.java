package 단계별.배열1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob3052 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // OPTION 1 : 132ms 14188KB

        int[] intArray = new int[10];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            intArray[i] = Integer.parseInt(br.readLine()) % 42;
        }

        for (int i = 0; i < 10; i++) {
            
            int dupli = 0;
            
            for (int j = i+1; j < 10; j++) {
                if (intArray[i] == intArray[j]){
                    dupli++;
                }
            }

            if (dupli == 0) {
                count++;
            }
        }

        sb.append(count);

        // OPTION 2 : 128ms 14232KB

        int[] intArray2 = new int[42];
        int count2 = 0;

        for (int i = 0; i < 10; i++) {
            intArray2[Integer.parseInt(br.readLine()) % 42]++;
        }

        for (int i = 0; i < 42; i++) {
            if(intArray2[i] != 0){
                count2++;
            }
        }

        sb.append(count2);
        System.out.println(sb);

        br.close();
    }
}
