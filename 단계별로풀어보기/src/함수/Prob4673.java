package 함수;

import java.io.IOException;
import java.util.ArrayList;

public class Prob4673 {
    static int Self_number(int num) {

        int next_num = num;

        while(num > 0) {
            next_num += num % 10;
            num /= 10;
        }

        return next_num;
    }
    
    public static void main(String[] args) throws IOException {

        // OPTION 1 : 228ms 15180KB     
        
        // TO 이 방법 말고 다른 방법도 찾아보기

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
