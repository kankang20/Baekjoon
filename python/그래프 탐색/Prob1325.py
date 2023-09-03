
""" 실버 1. 효율적인 해킹 """

from collections import deque
import sys

### 입력
input = sys.stdin.readline

N, M = map(int, input().split())        # 컴퓨터의 개수 N, 신뢰 관계 개수 M
computers = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())    # a가 b를 신뢰한다 > b를 해킹하면 a도 해킹할 수 있다.
    computers[b].append(a)


### 함수
def solution():
    answers = []

    for idx in range(1, N+1):
        answers.append((idx, bfs(idx)))

    answer = answers[0][1]

    for a in sorted(answers, key=lambda x : (-x[1], x[0])):
        if answer == a[1]:
            print(a[0], end = " ")
        else: 
            break


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


### 실행
solution()