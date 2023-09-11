
""" 실버 5. 수들의 합 """

import sys

input = sys.stdin.readline
S = int(input())

def solution(start, end):
    answer = 0

    while start <= end:
        mid = (start + end) // 2

        if (mid * (mid + 1)) / 2 <= S:
            answer = mid
            start = mid + 1
        else:
            end = mid - 1

    return answer

print(solution(0, S))