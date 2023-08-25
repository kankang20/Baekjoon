
""" 실버 3. 바이러스 """

# 입력
N = int(input())    # 컴퓨터 수
M = int(input())    # 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

computer = [[0] * (N+1) for _ in range(N+1)]
visited = [0] * (N+1)

for _ in range(M):
    i, j = map(int, input().split())
    computer[i][j] = computer[j][i] = 1


# 함수
def dfs(start):

    visited[start] = 1

    for i in range(1, N+1):
        if not visited[i] and computer[start][i]:
            dfs(i)


# 실행
dfs(1)
print(visited.count(1) - 1)