package PROGRAMMERS.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 최소직사각형 {
    public static void main(String[] args) {

        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes1));

        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution(sizes2));

        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution(sizes3));

        int[][] sizes4 = {{3, 4}, {2, 1}};
        System.out.println(solution(sizes4));

    } // end main

    public static int solution(int[][] sizes) {

        int answer = Integer.MAX_VALUE;

        // 중복되는 길이가 있을 수 있기 때문에 우선은 중복 제거
        List<Integer> width = new ArrayList<>();
        List<Integer> height = new ArrayList<>();

        for (int[] size : sizes) {
            if (!width.contains(size[0])) {
                width.add(size[0]);
            }
        }

        for (int[] size : sizes) {
            if (!height.contains(size[1])) {
                height.add(size[1]);
            }
        }

        // 이제 하나씩 해보면 돼
        for (Integer w : width) {
            for (Integer h : height) {
                if(check(w, h, sizes)) { // 최소값 갱신하기
                    answer = Math.min(answer, w*h);
                }
            }
        }
        
        return answer;
    } // end solution

    private static boolean check(int w, int h, int[][] sizes) {

        int width = 0, height = 0;

        for (int[] size: sizes) {

            width = size[0];
            height = size[1];

            if(width <= w && height <= h) continue;
            if(width <= h && height <= w) continue;
            return false;
        }
        return true;
    } // end check
}
