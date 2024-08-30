
"""
title  : 2029. 몫과 나머지 출력하기 (D1)
time   : 110ms
memory : 44532kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        num1, num2 = map(int, input().split())
        print(f'#{tc} {num1//num2} {num1%num2}')

solution()