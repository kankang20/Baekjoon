
""" 예제 5-6) 음료수 얼려 먹기 (DFS)"""

'''
4 5
00110
00011
11111
00000

>> 3

15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111 

>> 8
'''

R, C = map(int, input().split())
graph = [list(map(int, input())) for _ in range(R)]

visited = [[0] * C for _ in range(R)]
dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]


def dfs(nowr, nowc):

    visited[nowr][nowc] = 1

    for d in range(4):

        nr = nowr + dr[d]
        nc = nowc + dc[d]

        if nr < 0 or nc < 0 or nr >= R or nc >= C or visited[nr][nc] or graph[nr][nc]:
            continue

        dfs(nr, nc)


answer = 0

for r in range(R):
    for c in range(C):
        if not graph[r][c] and not visited[r][c]:
            answer += 1
            dfs(r, c)

print(answer)