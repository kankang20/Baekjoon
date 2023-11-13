
""" 실버 1. 숨바꼭질 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N, K = map(int, input().split())    # 수빈이 위치 N, 동생 위치 K

    return search(N, K)

def search(N, K):

    visited = [abs(N-K)] * (100001)

    q= deque()

    q.append((N, 0))
    visited[N] = 0

    return visited[K]

print(solution())