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

        StringBuilder answer = new StringBuilder();

        int posL = 10, posR = 12;
        int lengthL = 0, lengthR = 0, countR = 0, countL = 0;

        for (int number : numbers) {

            if(number == 1 || number == 4 || number == 7) {
                posL = number;
                answer.append("L");
            } else if (number == 3 || number == 6 || number == 9) {
                posR = number;
                answer.append("R");
            } else {

                if(number == 0) number = 11;

                countR = Math.abs(number - posR);
                countL = Math.abs(number - posL);

                lengthL = countL / 3 + countL % 3;
                lengthR = countR / 3 + countR % 3;

                if(lengthR < lengthL) {
                    posR = number;
                    answer.append("R");
                } else if (lengthR > lengthL) {
                    posL = number;
                    answer.append("L");
                } else {    // 두 길이가 동일한 경우
                    if(hand.equals("right")) {
                        posR = number;
                        answer.append("R");
                    } else {
                        posL = number;
                        answer.append("L");
                    }
                } // end else
            } // end if-else
        } //end for
        return answer.toString();
    }
}
