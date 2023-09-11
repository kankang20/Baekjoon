
""" 실버 4. 정수 제곱근 """

import sys

input = sys.stdin.readline
N = int(input())

def solution(start, end):

    answer = 0

    while start <= end:
        mid = (start + end) // 2

        if mid * mid < N:
            start = mid + 1
        else:
            answer = mid
            end = mid - 1

    return answer

print(solution(0, N))
