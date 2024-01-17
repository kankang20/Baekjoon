
""" 골드 5. 치킨 배달 """

import sys
from itertools import combinations

def solution():

    input = sys.stdin.readline
    N, M = map(int, input().split())

    chicken = []
    house = []
    for i in range(N):              
        temp = list(map(int, input().split()))      # 0 빈칸, 1 집, 2 치킨집
        for j in range(N):
            if temp[j] == 1:
                house.append((i, j))
            if temp[j] == 2:
                chicken.append((i, j))

    answer = 1e9
    for selected_chicken in combinations(chicken, M):
        temp_answer = 0
        for (hr, hc) in house:
            distance = 1e9
            for (cr, cc) in selected_chicken:
                distance = min(distance, abs(hr-cr) + abs(hc-cc))
            temp_answer += distance
        answer = min(answer, temp_answer)

    return answer

print(solution())