
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

    count = 0

    print(problem)

    while problem:

        print(problem[0], answer)
        next_deadline = problem[0][1]

        if deadline < next_deadline:
            count += 1
            continue
        elif deadline == next_deadline:
            # 같으면 같은 컵라면 개수 전체 가져오기
            temp = []
            while deadline == problem[0][1]:
                temp.append(problem.pop())
            if len(temp) <= (count+1):
                answer = sum(temp)
            else:
                answer = sum(sorted(temp)[:count])
        
    
    return answer


print(solution())