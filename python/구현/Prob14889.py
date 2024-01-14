
""" 실버 1. 스타트와 링크 """

import sys
from itertools import combinations

def solution():

    input = sys.stdin.readline

    N = int(input())
    ab = []
    for _ in range(N):
        ab.append(list(map(int, input().split())))

    answer = 1e9
    for t in list(combinations([i for i in range(N)], N//2)):

        diff = 0
        for i in range(N):
            for j in range(i+1, N):
                if i in t and j in t:
                    diff += ab[i][j]
                    diff += ab[j][i]
                elif i not in t and j not in t:
                    diff -= ab[i][j]
                    diff -= ab[j][i]
        answer = min(answer, abs(diff))

    return answer

print(solution())