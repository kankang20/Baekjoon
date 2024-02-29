
""" 실버 3. 1로 만들기 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    table = [0] * (N+1)
    for num in range(2, N+1):
        
        table[num] = table[num-1] + 1
        if num % 2 == 0:
            table[num] = min(table[num], table[num//2] + 1)
        if num % 3 == 0:
            table[num] = min(table[num], table[num//3] + 1)

    return table[N]

print(solution())