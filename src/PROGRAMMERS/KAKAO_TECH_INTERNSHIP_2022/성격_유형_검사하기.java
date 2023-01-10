package PROGRAMMERS.KAKAO_TECH_INTERNSHIP_2022;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {

    public static void main(String[] args) {

        String[] survey1 = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices1 = { 5, 3, 2, 7, 5 };

        System.out.println(solution(survey1, choices1));

        String[] survey2 = { "TR", "RT", "TR" };
        int[] choices2 = { 7, 1, 3 };

        System.out.println(solution(survey2, choices2));
    }

    /**
     * @param survey  질문마다 판단하는 지표를 담은 1차원 문자열 배열
     * @param choices 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열
     * @return 검사자의 성격 유형 검사 결과를 지표 변호 순서대로 반환
     */
    public static String solution(String[] survey, int[] choices) {

        String answer = "";

        String[] standard = { "RT", "CF", "JM", "AN" };

        Map<Character, Integer> map = new HashMap<>();

        for (String stan : standard) {
            map.put(stan.charAt(0), 0);
            map.put(stan.charAt(1), 0);
        }

        int choice = 0, num = 0;
        char temp = ' ';

        for (int i = 0, end = survey.length; i < end; i++) {

            choice = choices[i] - 4;

            if (choice < 0) { // charAt(0)

                temp = survey[i].charAt(0);

                num = map.get(temp) - choice;

            } else if (choice > 0) { // charAt(1)

                temp = survey[i].charAt(1);

                num = map.get(temp) + choice;
            }

            map.replace(temp, num);
        }

        // 성격 유형
        char c1 = ' ', c2 = ' ';

        for (String stan : standard) {

            c1 = stan.charAt(0);
            c2 = stan.charAt(1);

            if (map.get(c1) < map.get(c2)) { // c2의 점수가 크면
                answer += c2;
            } else { // 값이 동일하거나 c1의 점수가 크면
                answer += c1;
            }
        }

        return answer;
    }
}
