
"""
title  : 13549. 숨바꼭질 3 (Gold 5)
time   : 104ms      172ms
memory : 34288KB    115328KB
"""

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N, K = map(int, input().split())    # 수빈이 위치 N, 동생 위치 K

    return search(N, K)

def search(N, K):

    visited = [False] * (100001)
    count = 0

    q= deque()

    q.append((N, count))
    visited[N] = True

    while q:

        now, count = q.popleft()

        if now == K:
            return count
        
        next = now * 2
        if next < 100001 and not visited[next]:
            q.append((next, count))
            visited[next] = True

        next = now - 1
        if 0 <= next and not visited[next]:
            q.append((next, count + 1))
            visited[next] = True

        next = now + 1
        if next <= 100000 and not visited[next]:
            q.append((next, count + 1))
            visited[next] = True

        
    return count

print(solution())