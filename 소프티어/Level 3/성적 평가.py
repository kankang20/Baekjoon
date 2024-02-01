
""" Lv 3. [HSAT 5회 정기 코딩 인증평가 기출] 성적 평가 """

import sys
from heapq import heappush, heappop

def solution():
    input = sys.stdin.readline
    N = int(input())        # 참가자의 수

    last_grade = [0] * N
    grade= []
    for _ in range(3):
        for idx, g in enumerate(list(map(int, input().split()))):
            heappush(grade, (-g, idx))
            last_grade[idx] += g
        calculate_grade(N, grade)

    for idx in range(N):
        heappush(grade, (-last_grade[idx], idx))
    calculate_grade(N, grade)

def calculate_grade(N:int, grade:list):

    rank = [0] * N
    pre, r = -1, 1
    for idx in range(1,N+1):

        g, gdx = heappop(grade)

        if pre == g:
            rank[gdx] = r
        else:
            rank[gdx] = idx
            r = idx
        pre = g

    print(" ".join(map(str, rank)))

solution()
