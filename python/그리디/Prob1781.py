
""" 골드 2. 컵라면 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())            # 숙제의 개수
    problem = [list(map(int, input().split())) for _ in range(N)]

    print(problem)

print(solution())