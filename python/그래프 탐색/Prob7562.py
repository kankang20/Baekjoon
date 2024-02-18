
""" 실버 1. 나이트의 이동 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    dir = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
    
    for _ in range(int(input())):   # 테스트케이스

        N = int(input())                            # 체스판의 한 변 길이
        pos = list(map(int, input().split()))       # 나이트의 현재 칸
        target = list(map(int, input().split()))    # 나이트가 이동하려는 칸

        print(bfs(N, pos, target, dir))

def bfs(N:int, pos:list, target:list, dir:list):

    q = deque()
    q.append((pos[0], pos[1]))

    selected = [[False] * N for _ in range(N)]
    selected[pos[0]][pos[1]] = True

    answer = 0
    while q:

        for _ in range(len(q)):

            r, c = q.popleft()

            if r == target[0] and c == target[1]:
                return answer

            for d in dir:
                nr = r + d[0]
                nc = c + d[1]

                if 0 <= nr < N and 0 <= nc < N and not selected[nr][nc]:
                    q.append((nr, nc))
                    selected[nr][nc] = True

        answer += 1

    return answer

solution()