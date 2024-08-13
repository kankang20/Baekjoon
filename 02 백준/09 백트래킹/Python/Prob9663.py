
"""
title  : 9663. N-Queen (Gold 4)
time   : 시간초과        30736ms
memory : X              202196KB
"""

import sys

input = sys.stdin.readline

N = int(input())
answer = 0

col = [0] * N

def check(row:int):
    for idx in range(row):
        if col[row] == col[idx] or (row - idx) == abs(col[row] - col[idx]):
            return False
    return True

def queen(row:int):

    if row == N:
        global answer
        answer += 1
        return
    
    for idx in range(N):
        col[row] = idx
        if check(row):
            queen(row+1)

queen(0)
print(answer)
