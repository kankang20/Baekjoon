package PROGRAMMERS.코딩테스트.완전탐색;

import java.util.Arrays;

public class LV2_카펫 {

	public static int[] solution(int brown, int yellow) {
		int[] answer = {0, 0};
		
		int sum = brown + yellow;
		int width, height;
		
		for (int i = 1; i <= sum; i++) {
			
			if (sum % i == 0) {
				width = i; height = sum / i;
				if (width >= 3 && height >= 3 && (width-2)*(height-2)==yellow) {
					answer[0] = width;  answer[1] = height;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
		
	}
}

