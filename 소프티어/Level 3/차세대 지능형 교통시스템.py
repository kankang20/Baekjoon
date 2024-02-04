
""" Lv 3. [HSAT 1회 정기 코딩 인증평가 기출] 안전운전을 도와줄 차세대 지능형 교통시스템 """

import sys

def solution():
    input = sys.stdin.readline

    N, T = map(int, input().split())

    cross_line = dict()
    for r in range(1, N+1):
        for c in range(1, N+1):
            cross_line[(r, c)] = list(map(int, input().split()))

    

print(solution())

# 3 3
# 2 6 12 9
# 7 1 11 6
# 6 3 5 11
# 1 1 12 9
# 3 11 8 2
# 1 7 11 9
# 4 6 2 3
# 2 4 2 4
# 6 9 2 6