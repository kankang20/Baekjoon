package PROGRAMMERS.완전탐색;

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

        int small = 0, big = 0;

        for (int[] size : sizes) {

            small = Math.max(Math.min(size[0], size[1]), small);
            big = Math.max(Math.max(size[0], size[1]), big);
        }

        return small * big;
    } // end solution
}
