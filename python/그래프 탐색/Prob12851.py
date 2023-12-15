
""" 골드 4. 숨바꼭질 2 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline
    N, K = map(int, input().split())        # 수빈이 위치 N, 동생 위치 K

    return search(N, K)

def search(N, K):

    visited = [0] * (100001)

    q = deque()
    q.append((N, 0))

    value, count = 1e9, 0

    while q:

        now, move = q.popleft()

        if move > value:
            continue

        if now == K:
            value = move
            count += 1
            continue

        for next in (now-1, now+1, now*2):
            if 0 <= next <= 100000 and (not visited[next] or visited[next] == move + 1):
                q.append((next, move+1))
                visited[next] = move + 1

    return value, count

value, count = solution()
print(value)
print(count)