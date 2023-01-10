package PROGRAMMERS.KAKAO_BLIND_RECRUITMENT_2022;

public class 양궁대회 {

    public static void main(String[] args) {

        int n1 = 5;
        int[] info1 = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };

        solution(n1, info1);

        int n2 = 1;
        int[] info2 = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        solution(n2, info2);

        int n3 = 9;
        int[] info3 = { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 };

        solution(n3, info3);

        int n4 = 10;
        int[] info4 = { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 };

        solution(n4, info4);
    }

    private static int[] lion_info, answer;
    private static int allCount, ans;

    /**
     * 
     * @param n    화살 개수
     * @param info 어피치가 맞힌 과녁 점수의 개수를 10점부터 0점까지 순서대로 담은 정수 배열
     * @return 라이언이 맞혀야 하는 점수를 10점부터 0점까지 순서대로담은 정수 배열
     */
    public static int[] solution(int n, int[] info) {

        allCount = n; // 총 화살 개수
        ans = Integer.MIN_VALUE; // 어피치와 라이언 점수 차

        lion_info = new int[11]; // 매회 선택되는 라이언 점수
        answer = new int[11]; // 최종 라이언 점수

        // contest()

        return answer;
    }

    public static void recursive(int cnt) {

        if (cnt == allCount) {
            // 어피치와 라이언 점수 대결

            return;
        }

        for (int i = 0; i < 12; i++) {
            lion_info[i]++;
            recursive(cnt + 1);
            lion_info[i]--;
        }

    }
}
