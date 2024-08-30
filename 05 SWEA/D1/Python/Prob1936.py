
"""
title  : 1936. 1대1 가위바위보 (D1)
time   : ms
memory : kb
"""

def solution():

    a, b = map(int, input().split())

    answer = ""
    if (abs(a - b) == 1):
        if (a < b): answer = "B"
        else: answer = "A"
    else:
        if (a == 1): answer = "A"
        else: answer = "B"
    
    print(answer)

solution()