
""" 실버 4. 치킨치킨치킨 """

import sys

def solution():

    N, M = map(int, input().split())        # 회원 수 N, 치킨 종류의 수 M

    chicken = []                            # 치킨 선호도
    for _ in range(N):
        chicken.append(list(map(int, input().split())))


print(solution())