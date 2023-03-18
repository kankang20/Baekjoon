package PROGRAMMERS.힙;

import java.util.PriorityQueue;

public class 더_맵게 {

    public static void main(String[] args) {

        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;

        System.out.println(solution(scoville1, K1));

//        int[] scoville2 = {2};
//        int K2 = 7;
//
//        System.out.println(solution(scoville2, K2));
//
//        int[] scoville3 = {9};
//        int K3 = 7;
//
//        System.out.println(solution(scoville3, K3));
    }

    public static int solution(int[] scoville, int K) {

        // 낮은 숫자가 우선순위
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int number : scoville) {
            heap.add(number);
        }

        int num1 = 0, num2 = 0, answer = 0;

        while(heap.size() > 1) {

            num1 = heap.poll();
            if(num1 >= K) break;
            num2 = heap.poll();

            heap.add(num1 + num2*2);
            answer++;
        }

        return heap.poll() >= K?answer:-1;
    } // end solution
}
