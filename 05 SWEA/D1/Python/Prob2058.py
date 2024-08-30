
"""
title  : 2058. 자릿수 더하기 (D1)
time   : 98ms
memory : 44532kb
"""

def solution():

    number = input().rstrip()
    answer = 0

    for num in number:
        answer += int(num)

    print(answer)

solution()