
""" 실버 3. 2xn 타일링 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    if N < 3:
        return N

    table = [0] * (N+1)
    table[1] = 1
    table[2] = 2

    for idx in range(3, N+1):
        table[idx] = (table[idx-1] + table[idx-2]) % 10007

    return table[N]

print(solution())