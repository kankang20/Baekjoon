
""" 실버 1. 효율적인 해킹 """

from collections import deque
import sys

input = sys.stdin.readline

N, M = map(int, input().split())        # 컴퓨터의 개수 N, 신뢰 관계 개수 M
computers = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())    # a가 b를 신뢰한다 > b를 해킹하면 a도 해킹할 수 있다.
    computers[b].append(a)


def solution():
    answers = []
    max_ans = -1

    for idx in range(1, N+1):
        ans = bfs(idx)
        if max_ans < ans:
            max_ans = ans
            answers.clear()
            answers.append(idx)
        elif max_ans == ans:
            answers.append(idx)

    for a in answers:
        print(a, end = " ")


def bfs(start):

    visited = [False] * (N+1)

    queue = deque()
    queue.append(start)
    visited[start] = True

    count = 0

    while queue:
        now = queue.popleft()
        count += 1
        for com in computers[now]:
            if not visited[com]:
                queue.append(com)
                visited[com] = True

    return count


solution()