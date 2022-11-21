package BOJ.알고리즘.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 스도쿠 620ms 23780KB (java11) 552ms 18212KB (java8)
// 구현, 백트래킹

public class Prob2239 {

    private static boolean isgoing = false; // 스도쿠 완성 여부
    private static int[][] puzzle; // 스도쿠

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 /////////////////////////////////////////////////////////////

        puzzle = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = line.charAt(j) - '0';
            }
        }

        // 실행 /////////////////////////////////////////////////////////////

        sudoku(0, 0);
        System.out.println(sb);
    }

    private static void sudoku(int row, int col) {

        if (isgoing)
            return; // 이미 스도쿠를 완성했기 때문에 다른 스도쿠를 찾지 않음

        if (row == 9) { // 모든 행을 실행 완료하면
            isgoing = true; // 더이상 스도쿠를 완성하지 않도록
            // 스도쿠 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(puzzle[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        if (col == 9) { // 한 행의 마지막 열까지 실행 완료
            sudoku(row + 1, 0); // 다음 행부터 스도쿠 찾기
            return;
        }

        if (puzzle[row][col] == 0) { // 숫자를 넣을 위치면
            for (int i = 1; i <= 9; i++) { // 1부터 9까지의 숫자 삽입하면서 확인
                if (check(row, col, i)) { // 가능한 숫자면
                    puzzle[row][col] = i; // 숫자 삽입
                    sudoku(row, col + 1); // 다음 스도쿠 탐방
                }
            }
            puzzle[row][col] = 0; // 숫자가 잘못되었을 경우 0으로 초기화
            return; // 잘못되었으니 되돌아가기
        }

        sudoku(row, col + 1); // 다음 스도쿠 탐방
    }

    private static boolean check(int row, int col, int num) {
        // 불가능한 숫자면 false 가능한 숫자면 true

        // 행에서 겹치는 숫자가 없어야 함
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == num)
                return false;
        }

        // 열에서 겹치는 숫자가 없어야 함
        for (int i = 0; i < 9; i++) {
            if (puzzle[i][col] == num)
                return false;
        }

        // 3x3 에서 겹치는 숫자가 없어야 함
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (puzzle[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
