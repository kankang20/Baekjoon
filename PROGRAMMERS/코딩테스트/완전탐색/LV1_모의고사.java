package PROGRAMMERS.코딩테스트.완전탐색;

import java.util.Arrays;

public class LV1_모의고사 {
	
	// 1번 -> 1 2 3 4 
	// 2번 -> 2 1 2 3 2 4 2 5 
	// 3번 -> 3 3 1 1 2 2 4 4 5 5
	
	public static int[] solution (int[] answers) {
		
		int[] pattern1 = {1, 2, 3, 4, 5};
		int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[] score = {0, 0, 0};
		
		for (int i = 0; i < answers.length; i++) {
			int problem = answers[i];
			if (problem == pattern1[i%5]) score[0]++;
			if (problem == pattern2[i%8]) score[1]++;
			if (problem == pattern3[i%10]) score[2]++;
		}
		
		int max = Math.max(Math.max(score[0], score[1]), score[2]);
		int[] maxScore = new int[3];
		int index = 0;
		
		for (int j = 0; j < 3; j++) {
			if (max == score[j]) maxScore[index++] = (j+1);
		}
		
		return Arrays.copyOf(maxScore, index);
	}

	public static void main(String[] args) {
		
		int[] a1 = {1, 2, 3, 4, 5};
		int[] a2 = {1, 3, 2, 4, 2};
		
		System.out.println(Arrays.toString(solution(a1)));
		System.out.println(Arrays.toString(solution(a2)));
		
		
		
	}
}
