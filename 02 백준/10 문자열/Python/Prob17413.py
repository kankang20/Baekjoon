
"""
title  : 17413. 단어 뒤집기 2 (Silver 3)
time   : 52ms        512ms
memory : 32684KB     135388KB
"""

import sys

def solution():

    input = sys.stdin.readline
    S = input().rstrip()

    answer = ""

    temp = []
    flag = False
    
    for s in S:
        
        if flag:
            if s == ">":
                flag = False
            answer += s
            continue

        if s == "<":
            answer += "".join(reversed(temp))
            temp.clear()
            flag = True
            answer += "<"
        elif s == " ":
            answer += "".join(reversed(temp)) + " "
            temp.clear()
        else:
            temp.append(s)

    return answer + "".join(reversed(temp))

print(solution())