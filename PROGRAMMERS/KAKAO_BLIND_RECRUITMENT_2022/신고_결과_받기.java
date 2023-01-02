package PROGRAMMERS.KAKAO_BLIND_RECRUITMENT_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 신고_결과_받기 {

    public static void main(String[] args) {

        String[] id_list1 = { "muzi", "frodo", "apeach", "neo" };
        String[] report1 = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k1 = 2;

        System.out.println(Arrays.toString(solution(id_list1, report1, k1)));

        String[] id_list2 = { "con", "ryan" };
        String[] report2 = { "ryan con", "ryan con", "ryan con", "ryan con" };
        int k2 = 3;

        System.out.println(Arrays.toString(solution(id_list2, report2, k2)));

    }

    /**
     * 
     * @param id_list 이용자의 ID가 담긴 문자열 배열
     * @param report  각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열
     * @param k       정지 기준이 되는 신고 횟수
     * @return 각 유저별로 처리 결과 메일을 받은 횟수
     */
    public static int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        ArrayList<String> temp = null;

        // 신고 ///////////////////////////////////////////////////////////////////////

        Map<String, ArrayList<String>> reportList = new HashMap<>(); // 각 ID가 신고한 ID 목록

        for (int i = 0, end = report.length; i < end; i++) {

            StringTokenizer st = new StringTokenizer(report[i], " ");
            String fromID = st.nextToken(); // 신고한 사람
            String toID = st.nextToken(); // 신고 받은 사람

            // 내가 신고한 사람은 누구?
            temp = reportList.getOrDefault(fromID, new ArrayList<String>());

            if (!temp.contains(toID)) {
                temp.add(toID);
                reportList.put(fromID, temp);
            }
        }

        // 정지 /////////////////////////////////////////////////////////////////////

        Map<String, Integer> countList = new HashMap<>(); // ID가 신고받은 횟수

        for (String id : reportList.keySet()) {

            temp = reportList.get(id);

            for (String reportID : temp) {
                countList.put(reportID, countList.getOrDefault(reportID, 0) + 1);
            }
        }

        ArrayList<String> notID = new ArrayList<>();

        for (String id : countList.keySet()) {
            if (countList.get(id) >= k)
                notID.add(id);
        }

        // 메일 전송 ////////////////////////////////////////////////////////////////

        for (int i = 0, end = id_list.length; i < end; i++) {

            temp = reportList.get(id_list[i]);

            if (temp == null)
                continue;

            for (String id : notID) {
                if (temp.contains(id)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
