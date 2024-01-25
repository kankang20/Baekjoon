
""" Lv 1. 근무 시간 """

import sys
import re

def solution():
    input = sys.stdin.readline

    answer = 0
    for _ in range(5):
        temp = list(map(int, re.split(r':| ', input().rstrip())))
        answer += (temp[2] * 60 + temp[3]) - (temp[0] *60 + temp[1])

    return answer
    
print(solution())