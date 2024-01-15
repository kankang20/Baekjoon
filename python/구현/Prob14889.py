
""" 실버 1. 스타트와 링크 """

import sys

answer = 1e9

def solution():
    input = sys.stdin.readline

    N = int(input())
    ab = []
    for _ in range(N):
        ab.append(list(map(int, input().split())))

    selected = [False for _ in range(N)]
    check(N, 0, ab, selected, 0)

    return answer

def check(N, count, ab, selected, idx):

    if count == N//2:
        diff = 0
        for i in range(N):
            for j in range(i+1, N):
                if selected[i] and selected[j]:
                    diff += ab[i][j]
                    diff += ab[j][i]
                elif not selected[i] and not selected[j]:
                    diff -= ab[i][j]
                    diff -= ab[j][i]
        global answer
        answer = min(answer, abs(diff))
    
    for i in range(idx, N):
        if not selected[i]:
            selected[i] = True
            check(N, count+1, ab, selected, i+1)
            selected[i] = False

print(solution())