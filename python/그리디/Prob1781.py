
""" 골드 2. 컵라면 """

import sys
from heapq import heappush, heappop, heapify

# 2 6 3 1 7 5 4
# 1 2 3 1 6 2 3

# 2, 6, 3, 7만 데드라인에 맞춰가능 - 15개의 컵라면

def solution():

    input = sys.stdin.readline

    N = int(input())            # 숙제의 개수
    
    problem = []
    for _ in range(N):
        day, cup = map(int, input().split())
        heappush(problem, (day, cup))

    answer = 0
    deadline = 1

    print(problem)

    while problem:

        (day, cup) = heappop(problem)
        deadline = day
        
        # 같은 날짜의 과제 중 max(컵라면) 구하기
        temp = []
        
        while problem:
            tday, tcup = heappop(problem)
            if tday == day:
                temp.append(tcup)
            else:
                heappush(problem, (tday, tcup))
                break
        
        answer += max(temp) if temp else 0
        if temp:
            print(temp)
            answer += max(temp)

        deadline += 1
        
    
    return answer


print(solution())