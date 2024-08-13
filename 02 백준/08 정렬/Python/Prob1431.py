
"""
title  : 1431. 시리얼 번호 (Silver 3)
time   : 44ms        116ms
memory : 31120KB     109240KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    number = [input().rstrip() for _ in range(N)]

    def calculate(num:str):
        temp = 0
        for n in num:
            if n.isdigit():
                temp += int(n)
        return temp

    answer = []
    for num in number:
        answer.append((num, calculate(num)))

    for (ans, _) in sorted(answer, key=lambda x : (len(x[0]), x[1], x)):
        print(ans)
    
solution()