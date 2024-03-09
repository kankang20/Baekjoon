
""" 실버 4. 걷기 """

import sys

def solution():
    input = sys.stdin.readline

    X, Y, W, S = map(int, input().split())

    sum_xy = X + Y
    min_xy = min(X, Y)

    return min(sum_xy * W, (sum_xy - min_xy * 2) * W + min_xy * S)

print(solution())