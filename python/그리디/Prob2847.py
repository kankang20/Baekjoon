
""" 실버 4. 게임을 만든 동준이 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 레벨의 수
    level = list(int(input()) for _ in range(N))

    answer = 0
    for idx in range(N-2, -1, -1):

        if level[idx+1] <= level[idx]:
            answer += (level[idx] - level[idx+1] + 1)
            level[idx] = level[idx+1] - 1 

    return answer

print(solution())