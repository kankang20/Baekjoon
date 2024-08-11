
/**
* title  : 42746. 가장 큰 수 (Level 2)
*/

import java.util.*;

public class Prob42746 {
    
    public static void main(String[] args) {

        int[] n1 = {6, 10, 2};
        System.out.println(solution(n1));

        int[] n2 = {3, 30, 34, 5, 9};
        System.out.println(solution(n2));

        int[] n3 = {547, 54, 5};
        System.out.println(solution(n3));

        int[] n4 = {0, 0, 0, 0};
        System.out.println(solution(n4));
    }

    public static String solution(int[] numbers) {

        String[] numberString = Arrays.stream(numbers)
                                        .mapToObj(String::valueOf)
                                        .toArray(String[]::new);

        Arrays.sort(numberString, (o1, o2) -> -(o1 + o2).compareTo(o2 + o1));

        if (numberString[0].equals("0")) {
            return "0";
        }

        return String.join("", numberString);
    }
}
