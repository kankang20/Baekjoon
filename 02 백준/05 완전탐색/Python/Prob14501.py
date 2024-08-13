
"""
title  : 14501. 퇴사 (Silver 3)
time   : 52ms        152ms
memory : 31120KB     111660KB
"""

import sys

answer = 0

def solution():

    input = sys.stdin.readline

    N = int(input())    # 퇴사 날짜
    M = []              # 상담하는데 걸리는 기간, 돈
    for _ in range(N):
        x, y = map(int, input().split())
        M.append((x, y))

    search(N, M, 0, 0)
    return answer

def search(N, M, day, money):

    if day > N:
        return
    
    global answer
    answer = max(money, answer)

    for idx in range(day, N):
        search(N, M, idx + M[idx][0], money + M[idx][1])

print(solution())