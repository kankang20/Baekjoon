package PROGRAMMERS.카카오_개발자_겨울_인턴십_2019;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {

        int[][] board1 = {{0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}};
        int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board1, moves1));   // 4

        int[][] board2 = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 4, 0},
                {1, 2, 2, 1}};
        int[] moves2 = {2, 3, 1, 4, 2, 3};

        System.out.println(solution(board2, moves2));   // 6

        int[][] board3 = {{0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 3},
                    {0, 2, 5, 0, 1},
                    {4, 2, 4, 4, 2},
                    {3, 5, 1, 3, 1}};
        int[] moves3 = {5, 1, 4};

        System.out.println(solution(board3, moves3));   // 2

    }

    /**
     * @param board 게임 화면의 격자의 상태가 담긴 2차원 배열
     * @param moves 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열
     * @return 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수
     */
    public static int solution(int[][] board, int[] moves) {

        int answer = 0, board_length = board.length, now_doll = -1;
        
        Stack<Integer> dolls = new Stack<>();   // 선택한 인형들을 저장
    
        for (int move : moves) {

            int row = 0, board_position = move - 1;

            // 인형 뽑기
            while(row < board_length && board[row][board_position] == 0) row++;

            if(row == board_length) continue;

            now_doll = board[row][board_position];
            board[row][board_position] = 0;

            // 인형 터트리기
            if(dolls.isEmpty()) {
                dolls.push(now_doll);
            } else {
                if(now_doll == dolls.peek()) {
                    dolls.pop();
                    answer += 2;
                } else {
                    dolls.push(now_doll);
                }
            }
        }

        return answer;
    }
}
