
"""
title  : 11399. ATM (Silver 4)
time   : 52ms       116ms
memory : 31256KB    113112KB
"""

N = int(input())                        # 사람 수
times = list(map(int, input().split())) # 각 사람이 인출하는데 걸리는 시간

answer = 0

times.sort()    # 제일 작은 시간을 최대로 더하고, 제일 큰 시간을 최소로 더하고

for time in times:
    answer += (time * N)
    N -= 1

print(answer)