
""" Lv 2. 금고털이 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline

    W, N = map(int, input().split())    # 배낭의 무게 W, 귀금속의 종류 N
    
    gem = []
    for _ in range(N):
        weight, price = map(int, input().split())   # 금속의 무게 weight, 무게당 가격 price
        heappush(gem, (-price, weight))             # 제일 가격이 비싼 금속이 먼저 나올 수 있도록

    answer = 0
    while W > 0 and gem:    # 배낭에 남은 공간이 있거나 남은 보석이 있는 경우만
        
        price, weight = heappop(gem)    

        # 배낭 공간이 금속의 무게보다 큰 경우 전체 보석을 담음
        # 배낭 공간이 금속의 무게보다 작은 경우 남은 공간만큼만 보석을 담음
        answer += -price * (weight if W >= weight else W)
        W -= weight

    return answer

print(solution())