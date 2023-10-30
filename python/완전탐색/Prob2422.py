
""" 실버 4. 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 """

from itertools import combinations

def solution():

    N, M = map(int, input().split())                # 아이스크림 종류의 수 N, 섞어먹으면 안되는 조합의 개수 M
    
    flavor = [[1] * (N+1) for _ in range(N+1)]
    for _ in range(M):
        a, b = map(int, input().split())
        flavor[a][b] = 0
        flavor[b][a] = 0

    answer = 0

    for (x, y, z) in list(combinations([num for num in range(1, N+1)], 3)):
        if flavor[x][y] and flavor[y][z] and flavor[z][x]:
            answer += 1

    return answer

print(solution())
