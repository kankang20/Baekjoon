
""" 실버 5. 뒤집기 """

import sys

def solution():
    input = sys.stdin.readline

    S = list(map(int, input().rstrip()))

    pattern, idx = [], 0
    while idx < len(S):
        pattern.append(S[idx])
        while idx < len(S)-1 and S[idx] == S[idx+1]:
            idx += 1
        idx += 1

    count = [0] * 2
    for p in pattern:
        count[p] += 1

    return min(count)

print(solution())