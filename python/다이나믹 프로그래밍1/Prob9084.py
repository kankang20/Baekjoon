
""" 골드 5. 동전 """

import sys

def solution():

    input = sys.stdin.readline

    T = int(input())                # 테스트케이스

    for _ in range(T):

        N = int(input())                            # 동전의 가지 수
        coins = list(map(int, input().split()))     # 동전의 각 금액 (오름차순)
        target = int(input())                       # 만들어야 할 금액

        answer = [[0] * (target+1) for _ in range(N+1)]

        print(answer)

print(solution())