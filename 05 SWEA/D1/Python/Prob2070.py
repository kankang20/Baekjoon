
"""
title  : 2070. 큰 놈, 작은 놈, 같은 놈 (D1)
time   : 107ms
memory : 43488kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        num1, num2 = map(int, input().split())

        answer = ""
        if num1 == num2:
            answer = "="
        elif num1 < num2:
            answer = "<"
        elif num1 > num2:
            answer = ">"
        
        print(f'#{tc} {answer}')

solution()