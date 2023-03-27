package PROGRAMMERS.코딩테스트_고득점_Kit.해시;

import java.util.HashMap;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {

        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(solution(participant1, completion1));

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant2, completion2));

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant3, completion3));
    }

    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        for (String name : completion) {
            map.put(name, map.get(name)-1);
        }

        for (String name : map.keySet()) {
            if(map.get(name) > 0) {
                answer = name;
                break;
            }
        }

        return answer;
    }
}
