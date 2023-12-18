
""" 골드 2. 컵라면 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input())            # 숙제의 개수

    maximum_day = 0
    problem = []
    for _ in range(N):
        day, cup = map(int, input().split())
        maximum_day = max(day, maximum_day)
        heappush(problem, (-cup, day))     

    selected = [False] * (maximum_day+1)
    answer = 0

    for _ in range(N):

        temp = heappop(problem)
        (cup, day) = -temp[0], temp[1]
        print("(cup, day) = (", cup, day, ")")

        while day > 0 and selected[day]:
            day -= 1
        
        if day == 0:
            continue

        selected[day] = True
        answer += cup

    return answer

print(solution())