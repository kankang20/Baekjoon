
""" 골드 2. 컵라면 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input())            # 숙제의 개수

    problem = []
    for _ in range(N):
        deadline, cup = map(int, input().split())
        heappush(problem, (deadline, cup))

    answer = []
    while problem:

        deadline, cup = heappop(problem)
        heappush(answer, cup)

        if deadline < len(answer):
            heappop(answer)
    
    return sum(answer)

print(solution())