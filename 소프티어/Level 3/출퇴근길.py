
""" Lv 3. [HSAT 6회 정기 코딩 인증평가 기출] 출퇴근길 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())        # 정점의 개수 N, 간선의 개수 M

    global adjacent_list
    adjacent_list = [[] for _ in range(N+1)]
    for _ in range(M):
        x, y = map(int, input().split())
        adjacent_list[x].append(y)

    S, T = map(int, input().split())        # 집 S, 회사 T

    visitedTFromS = [False] * (N+1)
    search(N, visitedTFromS, T, S)

    visitedSFromT = [False] * (N+1)
    search(N, visitedSFromT, S, T)

    # print(visitedTFromS[1:])
    # print(visitedSFromT[1:])

    answer = 0
    for node in range(N+1):
        if visitedTFromS[node] and visitedSFromT[node]:
            answer += 1

    return answer-2

def search(N:int, visited:list, destination:int, start:int):

    if start == destination:
        return
    
    for node in adjacent_list[start]:
        if not visited[node]:
            visited[node] = True
            search(N, visited, destination, node)

print(solution())

# 5 9
# 1 2
# 1 4
# 2 1
# 2 3
# 3 4
# 3 5
# 4 1
# 4 3
# 5 1
# 1 3

# 8 14
# 1 2
# 1 5
# 1 7
# 2 3
# 3 1
# 4 1
# 4 2
# 5 4
# 5 8
# 6 2
# 6 3
# 7 1
# 7 6
# 8 7
# 6 5
