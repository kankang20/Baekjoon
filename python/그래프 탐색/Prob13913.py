
""" 골드 4. 숨바꼭질 4 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    previous = [0] * (100001)
    previous[N] = N

    day = bfs(N, M, previous)

    answer = []

    node = M
    while node != N:
        answer.append(str(node))
        node = previous[node]
    answer.append((str(node)))

    print(day)
    print(" ".join(answer[::-1]))

def bfs(N, M, previous):

    q = deque()
    q.append((N, 0))    

    selected = [False] * (100001)
    selected[N] = True

    while q:

        now, day = q.popleft()

        if now == M:
            return day

        day += 1

        if now + 1 <= 100000 and not selected[now+1]:
            q.append((now+1, day))
            selected[now+1] = True
            previous[now+1] = now
        
        if 1 <= now and not selected[now-1]:
            q.append((now-1, day))
            selected[now-1] = True
            previous[now-1] = now

        if now * 2 <= 100000 and not selected[now*2]:
            q.append((now*2, day))
            selected[now*2] = True
            previous[now*2] = now

    return day


solution()