
"""
title  : 1697. 숨바꼭질 (Silver 1)
time   : 104ms      156ms
memory : 35300KB    115640KB
"""

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

    while q:

        now, count = q.popleft()

        if now == K:
            return count
        
        count += 1

        for now in (now-1, now+1, now*2):
            if 0 < now < 100001 and count < visited[now]:
                q.append((now, count))
                visited[now] = count

    return visited[K]

print(solution())