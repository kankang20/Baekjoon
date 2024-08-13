
"""
title  : 10971. 외판원 순회 2 (Silver 2)
time   : 136ms       160ms
memory : 31120KB     111492KB
"""

import sys

answer = 1e9

def solution():
    input = sys.stdin.readline

    global N, board
    N = int(input())                            # 도시 수
    board = [list(map(int, input().split())) for _ in range(N)]   # 도시 간 비용

    selected = [False] * N

    for c in range(N):
        selected[c] = True
        search_path(selected, c, c, 1, 0)
        selected[c] = False

    return answer

def search_path(selected:list, start:int, end:int, count_city:int, cost:int):

    if count_city == N:
        if board[end][start] > 0:
            global answer
            answer = min(answer, cost + board[end][start])
        return
    
    if cost >= answer:
        return
    
    for c in range(N):
        if not selected[c] and board[end][c] > 0:
            selected[c] = True
            search_path(selected, start, c, count_city + 1, cost + board[end][c])
            selected[c] = False
    
print(solution())