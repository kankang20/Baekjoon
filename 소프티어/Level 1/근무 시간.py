
""" Lv 1. 근무 시간 """

import sys

def solution():
    input = sys.stdin.readline

    answer = 0
    for _ in range(5):
        
        start, end = input().rstrip().split()
        
        h1,m1 = map(int, start.split(":"))
        h2,m2 = map(int, end.split(":"))

        answer += (h2 * 60 + m2) - (h1 * 60 + m1)

    return answer
    
print(solution())