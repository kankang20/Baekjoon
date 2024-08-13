
"""
title  : 1758. 알바생 강호 (Silver 4)
time   : 3792ms       252ms
memory : 35108KB      116156KB
"""

N = int(input())    # 줄 서 있는 사람 수 

tips = [int(input()) for _ in range(N)]     # 주려고 하는 팁

tips.sort(reverse = True)   # 팁이 큰 순서대로 정렬

answer = 0

for num in range(N):
    tip = tips[num] - num

    if tip > 0:
        answer += tip

print(answer)