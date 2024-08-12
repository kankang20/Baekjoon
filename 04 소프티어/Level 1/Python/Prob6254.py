
"""
title  : 6254. 근무 시간 (Level 1)
time   : 101ms
memory : 37.21MB
"""

import sys

def solution():

    answer = 0
    for _ in range(5):
        temp = list(input().split())
        h1, m1 = map(int, temp[0].split(":"))
        h2, m2 = map(int, temp[1].split(":"))

        answer += ((h2 * 60 + m2) - (h1 * 60 + m1))

    print(answer)
    
solution()