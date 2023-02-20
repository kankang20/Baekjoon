package PROGRAMMERS.KAKAO_인턴십_2020;

import java.util.Objects;

public class 키패드_누르기 {

    public static void main(String[] args) {

        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";

        System.out.println(solution(numbers1, hand1));
        System.out.println(solution(numbers2, hand2));
        System.out.println(solution(numbers3, hand3));
    }

    public static String solution(int[] numbers, String hand) {

        String answer = "";

        if(Objects.equals(hand, "right")) hand = "R";
        else hand = "L";

        for (int number : numbers) {


        }


        return answer;
    }
}
