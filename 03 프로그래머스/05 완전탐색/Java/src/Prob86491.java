
/**
* title  : 86491. 최소직사각형 (Level 1)
*/

public class Prob86491 {
    
    public static void main(String[] args) {

        int[][] s1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(s1));

        int[][] s2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution(s2));

        int[][] s3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution(s3));
    }

    public static int solution(int[][] sizes) {

        int wsize = 0;
        int hsize = 0;

        for (int i = 0; i < sizes.length; i++) {
            wsize = Math.max(wsize, Math.min(sizes[i][0], sizes[i][1]));
            hsize = Math.max(hsize, Math.max(sizes[i][0], sizes[i][1]));
        }

        return wsize * hsize;
    }
}
