
""" 실버 5. 좌표 정렬하기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    coor = []
    for _ in range(N):
        x, y = map(int, input().split())
        coor.append((x, y))

    for (x, y) in sorted(coor, key= lambda x : (x[0], x[1])):
        print(x, y)

solution()