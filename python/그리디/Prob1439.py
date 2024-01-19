
""" 실버 5. 뒤집기 """

import sys

def solution():
    input = sys.stdin.readline

    S = list(map(int, input().rstrip()))

    count, idx = [0, 0], 0
    while idx < len(S):
        count[S[idx]] += 1
        while idx < len(S)-1 and S[idx] == S[idx+1]:
            idx += 1
        idx += 1

    return min(count)

print(solution())