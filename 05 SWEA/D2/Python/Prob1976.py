
"""
title  : 1976. 시각 덧셈 (D2)
time   : 108ms
memory : 43216kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        h1, m1, h2, m2 = map(int, input().split())

        h = h1 + h2
        m = m1 + m2

        if 60 < m:
            h += 1
            m -= 60
        
        if 12 < h:
            h -= 12

        print(f'#{tc} {h} {m}')

solution()