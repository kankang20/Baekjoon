package PROGRAMMERS.스택큐;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr1)));

        int[] arr2 = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        // 첫번째 원소 처리
        int previous = arr[0];
        list.add(arr[0]);

        // 두번째 원소부터
        for (int i = 1, end = arr.length; i < end; i++) {
            if(previous != arr[i]) {
                list.add(arr[i]);
            }
            previous = arr[i];
        }

        // ArrayList to Array
        int[] answer = new int[list.size()];

        for (int i = 0, end = list.size(); i < end; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    } // end solution
}
