
"""
title  : 2217. 로프 (Silver 4)
time   : 4036ms       196ms
memory : 35500KB      116856KB
"""

N = int(input())    # 로프 갯수

rope = [int(input()) for _ in range(N)]     # 각 로프가 버틸 수 있는 최대 중량

rope.sort()     # 작은 수 부터 확인하기 위함

answer = 0

for num in range(N):
    answer = max(answer, rope[num] * (N - num))

print(answer)