
"""
title  : 29700. 우당탕탕 영화예매 (Silver 4)
time   : 1008ms     264ms
memory : 71396KB    153776KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())
    board = [list(map(int, input().rstrip())) for _ in range(N)]

    answer = 0
    for i in range(N):
        count = 0
        for j in range(M):
            if board[i][j] == 0:
                count += 1
                if count >= K:
                    answer += 1
            else:
                count = 0

    return answer

print(solution())