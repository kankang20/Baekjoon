
""" 실버 3. 바이러스 """

# 입력
N = int(input())    # 컴퓨터 수
M = int(input())    # 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

computer = [[] for _ in range(N+1)] 
visited = [0] * (N+1)

for _ in range(M):
    i, j = map(int, input().split())
    computer[i].append(j)
    computer[j].append(i)


# 함수
def dfs(start):

    visited[start] = 1
    
    for i in computer[start]:
        if not visited[i]:
            dfs(i)


# 실행
dfs(1)
print(visited.count(1) - 1)