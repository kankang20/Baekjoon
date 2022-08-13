package BOJ.단계별로_풀어보기.Step5_함수;

import java.io.IOException;
import java.util.ArrayList;

// 228ms 15180KB

public class Prob4673_1 {

    static int Self_number(int num) {

        int next_num = num;

        while(num > 0) {
            next_num += num % 10;
            num /= 10;
        }

        return next_num;
    }
    
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int number = 1;
        int next_number = 0;
        ArrayList<Integer> number_list = new ArrayList<>();

        while (number < 10000) {
            
            next_number = Self_number(number);

            number_list.add(next_number);
            number++;
        }

        for(int i = 1; i < number_list.size(); i++) {

            if (!number_list.contains(i)) {
                sb.append(i + "\n");
            }
        }
        
        System.out.println(sb);

    }
}