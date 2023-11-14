
""" 골드 5. 숨바꼭질 3 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N, K = map(int, input().split())    # 수빈이 위치 N, 동생 위치 K

    return search(N, K)

def search(N, K):

    visited = [abs(N-K)] * (100001)

    q= deque()

    q.append(N)
    visited[N] = 0

    while q:

        now = q.popleft()

        if now == K:
            return visited[now]
        
        count = visited[now]
        
        next = now * 2
        if next < 100001 and count < visited[next]:
            q.append(next)
            visited[next] = count

        next = now - 1
        if 0 < next and count < visited[next]:
            q.append(next)
            visited[next] = count + 1

        next = now + 1
        if next < 100001 and count < visited[next]:
            q.append(next)
            visited[next] = count + 1

    return visited[K]

print(solution())