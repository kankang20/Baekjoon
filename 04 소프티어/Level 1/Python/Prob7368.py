
"""
title  : 7368. 위험한 효도 (Level 1)
time   : 107ms
memory : 37.06MB
"""

import sys

def solution():
    input = sys.stdin.readline

    A, B, D = map(int, input().split())

    answer = 0

    # 앞으로 이동
    q = D // A
    r = D % A

    answer += (q * (A+B) + (r if r else -B))

    # 뒤로 이동
    q = D // B
    r = D % B

    answer += (q * (A+B) + (r if r else -A))

    print(answer)
    
solution()

