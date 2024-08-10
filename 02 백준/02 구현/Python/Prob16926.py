
"""
title  : 16926. 배열 돌리기 1 (Gold 5)
time   : 92ms       204ms
memory : 38432KB   	122904KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    R, C, N = map(int, input().split())         # 배열의 크기 R, C, 회전의 수 N
    board = [list(input().split()) for _ in range(R)]
    
    answer = [[0] * C for _ in range(R)]
    
    q = deque()
    for idx in range(min(R, C) // 2):

        for cdx in range(idx, C-1-idx, 1):
            q.append(board[idx][cdx])

        for rdx in range(idx, R-1-idx, 1):
            q.append(board[rdx][C-1-idx])

        for cdx in range(C-1-idx, idx, -1):
            q.append(board[R-1-idx][cdx])

        for rdx in range(R-1-idx, idx, -1):
            q.append(board[rdx][idx])

        q.rotate(-N)

        for cdx in range(idx, C-1-idx, 1):
            answer[idx][cdx] = q.popleft()

        for rdx in range(idx, R-1-idx, 1):
            answer[rdx][C-1-idx] = q.popleft()
        
        for cdx in range(C-1-idx, idx, -1):
            answer[R-1-idx][cdx] = q.popleft()

        for rdx in range(R-1-idx, idx, -1):
            answer[rdx][idx] = q.popleft()

    for ans in answer:
        print(" ".join(ans))

solution()