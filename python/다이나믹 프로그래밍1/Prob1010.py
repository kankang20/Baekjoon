
""" 실버 5. 다리 놓기  """

T = int(input())        # 테스트케이스
r, c = 1, 1

def solution(N, M):

    table = [[0] * 31 for _ in range(31)]

    if N == 1:
        return M

    for i in range(1, N+1):
        for j in range(1, M+1):

            if i == 1:
                table[i][j] = j
            else:
                table[i][j] = table[i-1][j-1] + table[i][j-1]

    return table[N][M]


for _ in range(T):
    N, M = map(int, input().split())
    print(solution(N, M))