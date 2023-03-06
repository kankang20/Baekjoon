package PROGRAMMERS.해시;

import java.util.HashMap;

public class 포켓몬 {
    public static void main(String[] args) {

        int[] nums1 = {3, 1, 2, 3};
        System.out.println(solution(nums1));

        int[] nums2 = {3, 3, 3, 2, 2, 4};
        System.out.println(solution(nums2));

        int[] nums3 = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums3));

        int[] nums4 = {3, 7, 6, 2, 8, 2};
        System.out.println(solution(nums4));
    }

    public static int solution(int[] nums) {

        int choice = nums.length / 2;   // 선택할 수 있는 폰켓몬의 종류

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            if(!map.containsKey(num)) {
                map.put(num, num);
            }

            if(map.size() >= choice) break;
        }

        return map.size();
    } // end solution
}
