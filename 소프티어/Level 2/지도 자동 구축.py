
""" Lv 2. 지도 자동 구축 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())        # iteration 횟수

    answer = 3
    for _ in range(1, N):
        answer += (answer-1)

    return answer*answer

print(solution())