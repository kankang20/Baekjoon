
"""
title  : 8979. 올림픽 (Silver 5)
time   : 44ms       116ms
memory : 31120KB    108080KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, K = map(int, input().split())
    
    result = []
    G, S, B = 0, 0, 0
    for _ in range(N):
        n, g, s, b = map(int, input().split())
        if n == K:
            G, S, B = g, s, b
        else:
            result.append((g, s, b))

    answer = 1
    for idx in range(N-1):
        temp = result[idx]
        if G < temp[0]:
            answer += 1
        elif G == temp[0]:
            if S < temp[1]:
                answer += 1
            elif S == temp[1]:
                if B < temp[2]:
                    answer += 1

    return answer 
        
print(solution())