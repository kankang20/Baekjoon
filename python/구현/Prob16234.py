
""" 골드 4. 인구 이동 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline

    N, L, R = map(int, input().split())         # 땅 크기 N, 인구 차이 최소 L, 최대 R

    people = []
    for _ in range(N):
        people.append(list(map(int, input().split())))

    day = 0

    while True:
        if people_move(N, L, R, people):
            return day
        day += 1

def people_move(N, L, R, people:list):

    visited = [[False] * N for _ in range(N)]

    def bfs(r, c):

        dr = [0, 0, 1, -1]
        dc = [1, -1, 0, 0]

        city = []
        q = deque()

        q.append((r, c))
        city.append((r, c))
        visited[r][c] = True

        total_people = people[r][c]

        while q:

            r, c = q.popleft()

            for d in range(4):

                nr = r + dr[d]
                nc = c + dc[d]

                if nr < 0 or nr >= N or nc < 0 or nc >= N or visited[nr][nc]:
                    continue

                diff = abs(people[r][c] - people[nr][nc])

                if diff < L or diff > R:
                    continue

                q.append((nr, nc))
                city.append((nr, nc))
                visited[nr][nc] = True

                total_people += people[nr][nc]

        for (r, c) in city:
            people[r][c] = total_people / len(city)

        return city

    total_city = 0

    for r in range(N):
        for c in range(N):

            if not visited[r][c]:

                city = bfs(r, c)

                if len(city) > 1:
                    total_city += len(city)
    
    return True if total_city else False



print(solution())