
"""
title  : 10814. 나이순 정렬 (Silver 5)
time   : 260ms       376ms
memory : 55356KB     135728KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 회원 수

    people = []
    for idx in range(N):
        age, name = input().rstrip().split()
        people.append((int(age), idx, name))

    people.sort(key=lambda x : (x[0], x[1]))
    
    for p in people:
        print(p[0], p[2])

solution()
