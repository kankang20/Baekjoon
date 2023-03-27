package PROGRAMMERS.코딩테스트_고득점_Kit.해시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 위장 {

    public static void main(String[] args) {

        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes1));

        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes2));
    }

    public static int solution(String[][] clothes) {

        int answer = 1;

        Map<String, List<String>> allClothes = new HashMap<>();

        for (String[] clothe : clothes) {
            List<String> list = allClothes.getOrDefault(clothe[1], new ArrayList<>());
            list.add(clothe[0]);
            allClothes.put(clothe[1], list);
        }

        // 은혜 (한 옷의 종류수 + 1(안입는경우의수)) * ... -(아무것도 안 입는경우의수)
        for (List<String> list : allClothes.values()) {
            answer *= (list.size() + 1);
        }

        return answer-1;
    } // end solution
}
