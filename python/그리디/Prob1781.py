
""" 골드 2. 컵라면 """

import sys
from heapq import heappush, heappop

# 2 6 3 1 7 5 4
# 1 2 3 1 6 2 3

# 2, 6, 3, 7만 데드라인에 맞춰가능 - 15개의 컵라면

def solution():

    input = sys.stdin.readline

    N = int(input())            # 숙제의 개수

    maximum_day = 0
    
    problem_list = []
    for _ in range(N):
        day, cup = map(int, input().split())
        problem_list.append((day, cup))
        maximum_day = max(day, maximum_day)

    # maximum_day = max(problem_list, key=lambda x:x[0])[0]
    # print("maximum_day = ", maximum_day)

    problem_heapq = []
    for (day, cup) in problem_list:
        heappush(problem_heapq, (-cup, day))      
        
    selected = [False] * (maximum_day+1)
    answer = 0

    for _ in range(N):

        temp = heappop(problem_heapq)
        (cup, day) = -temp[0], temp[1]
        print("(cup, day) = (", cup, day, ")")

        while selected[day] and day > 0:
            day -= 1
        
        if day == 0:
            continue

        selected[day] = True
        answer += cup

        

    return answer


print(solution())