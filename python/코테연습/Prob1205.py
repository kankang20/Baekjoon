
""" 실버 4. 등수 구하기 """

import sys

def solution():
    input = sys.stdin.readline

    N, G, P = map(int, input().split())

    if N == 0:
        return 1
    
    grade = list(map(int, input().split()))
    
    if N == P and G <= grade[-1]:
        return -1

    for idx in range(N):
        if grade[idx] <= G:
            return idx + 1

    return N + 1

print(solution())