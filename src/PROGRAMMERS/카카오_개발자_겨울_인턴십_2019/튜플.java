package PROGRAMMERS.카카오_개발자_겨울_인턴십_2019;

import java.util.*;

public class 튜플 {

    public static void main(String[] args) {

        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s1)));

        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(solution(s2)));

        String s3 = "{{20,111},{111}}";
        System.out.println(Arrays.toString(solution(s3)));

        String s4 = "{{123}}";
        System.out.println(Arrays.toString(solution(s4)));

        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(solution(s5)));
    }

    public static int[] solution(String s) {

        s = s.replace("{", "");
        s = s.replace("}", "");

        String[] numbers = s.split(",");

        Map<Integer, Integer> map = new HashMap<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        keys.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        int length = keys.size();

        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = keys.get(i);
        }

        return answer;
    }
}
