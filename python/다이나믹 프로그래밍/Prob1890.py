
""" 실버 1. 점프 """

import sys

def solution():
    input = sys.stdin.readline

    global N
    N = int(input())
    
    global array
    array = [list(map(int, input().split())) for _ in range(N)]

    global answer
    answer = [[0]*N for _ in range(N)]

    search(0, 0)
    print(answer)

    return answer[N-1][N-1]

def search(r, c):

    if r >= N or c >= N:
        return
    
    answer[r][c] += 1

    if r == N-1 and c == N-1:
        return

    search(r, c+array[r][c])        # 오른쪽으로 이동
    search(r+array[r][c], c)        # 아래쪽으로 이동

print(solution())