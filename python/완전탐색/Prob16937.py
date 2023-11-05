
""" 실버 3. 두 스티커 """

import sys

def solution():

    input = sys.stdin.readline

    R, C = map(int, input().split())
    N = int(input())                        # 스티커 수
    sticker = []
    for _ in range(N):
        r, c = map(int, input().split())
        sticker.append((r, c))


print(solution())