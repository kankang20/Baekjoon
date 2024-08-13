
"""
title  : 11047. 동전 0 (Silver 4)
time   : 40ms       108ms
memory : 31256KB    108080KB
"""

N, K = map(int, input().split())            # 동전 종류, 동전으로 만드는 가치의 합

coin = [int(input()) for _ in range(N)]     # 동전의 가치

answer = 0

for num in reversed(coin):

    answer += (K // num)

    K %= num

print(answer)