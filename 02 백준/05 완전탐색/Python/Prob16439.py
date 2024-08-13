
"""
title  : 16439. 치킨치킨치킨 (Silver 4)
time   : 60ms        128ms
memory : 31120KB     110592KB
"""

import sys
from itertools import combinations

def solution():
    
    input = sys.stdin.readline
    N, M = map(int, input().split())        # 회원 수 N, 치킨 종류의 수 M

    chicken = []                            # 치킨 선호도
    for _ in range(N):
        chicken.append(list(map(int, input().split())))

    answer = 0

    for temp in combinations([num for num in range(M)], 3):
        sum = 0
        for idx in range(N):
            sum += max(chicken[idx][temp[0]],chicken[idx][temp[1]],chicken[idx][temp[2]])
        answer = max(sum, answer)

    return answer

print(solution())