
""" Lv 3. GINI야 도와줘 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    # 비어있는 칸 . 소나기 * 강 X 태범이의 집 H 세차장 W

    R, C = map(int, input().split())

    taebum = deque()
    rain = deque()

    graph = []
    visited = [[False] * C for _ in range(R)]
    
    for r in range(R):
        graph.append(list(input().rstrip()))
        for c in range(C):
            if graph[r][c] == "W":
                taebum.append((r, c))
                visited[r][c] = True
            elif graph[r][c] == "*":
                rain.append((r, c))

    return move(R, C, graph, taebum, rain, visited)

def move(R:int, C:int, graph:list, taebum:deque, rain:deque, visited:list):

    dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    answer = 0

    while taebum:

        answer += 1

        # 태범이 움직이기
        for _ in range(len(taebum)):

            r, c = taebum.popleft()

            for (dr, dc) in dir:
                nr = r + dr
                nc = c + dc

                if 0 <= nr < R and 0 <= nc < C and not visited[nr][nc]:

                    if graph[nr][nc] == "H":
                        return answer
                    
                    if graph[nr][nc] == ".":
                        taebum.append((nr, nc))
                        visited[nr][nc] = True

        # 소나기 움직이기
        for _ in range(len(rain)):

            r, c = rain.popleft()

            for (dr, dc) in dir:
                nr = r + dr
                nc = c + dc

                if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] == ".":
                    rain.append((nr, nc))
                    graph[nr][nc] == "*"

    return "FAIL"


print(solution())