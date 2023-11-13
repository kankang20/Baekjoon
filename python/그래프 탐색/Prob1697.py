
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

    while q:

        now, count = q.popleft()

        if now == K:
            return visited[now]
        
        count += 1

        if 0 < now - 1 and count < visited[now-1]:
            q.append((now-1, count))
            visited[now-1] = count

        if now + 1 < 100001 and count < visited[now+1]:
            q.append((now+1, count))
            visited[now+1] = count

        if now*2 < 100001 and count < visited[now*2]:
            q.append((now*2, count))
            visited[now*2] = count

    return visited[K]

print(solution())