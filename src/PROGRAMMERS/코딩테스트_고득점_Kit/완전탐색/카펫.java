package PROGRAMMERS.코딩테스트_고득점_Kit.완전탐색;

import java.util.Arrays;

public class 카펫 {

    public static void main(String[] args) {

        int brown1 = 10;
        int yellow1 = 2;
        System.out.println(Arrays.toString(solution(brown1, yellow1)));

        int brown2 = 8;
        int yellow2 = 1;
        System.out.println(Arrays.toString(solution(brown2, yellow2)));

        int brown3 = 24;
        int yellow3 = 24;
        System.out.println(Arrays.toString(solution(brown3, yellow3)));

    }

    public static int[] solution(int brown, int yellow) {

        // brown = 가로 + 가로 + 세로 + 세로 - 4
        // yellow = (가로 - 2) * (세로 - 2) = 가로*세로 - 2*가로 - 2*세로 + 4
        // brown + yellow = 가로*세로

        int sum = brown + yellow;
        int[] size = new int[2];

        for (int i = 3; i < sum; i++) {

            if(sum % i == 0) {
                int height = sum/i;
                if(yellow == (i-2)*(height-2)) {
                    size[1] = i;
                    size[0] = sum/i;
                    break;
                }
            }
        }

        return size;
    }
}
