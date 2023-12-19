
""" 실버 2. N번째 큰 수 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input())                # 표의 크기

    answer = []
    for idx in range(N):
        for num in list(map(int, input().split())):
            
            if idx == 0:
                heappush(answer, num)
                continue

            if answer[0] < num:
                heappop(answer)
                heappush(answer, num)
    
    return heappop(answer)

print(solution())