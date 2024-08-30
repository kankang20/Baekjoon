
"""
title  : 2056. 연월일 달력 (D1)
time   : 101ms
memory : 43984kb
"""

def solution():

    maxDay = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    T = int(input())
    for tc in range(1, T+1):

        str = input().rstrip()
        y, m, d = str[:4], str[4:6], str[6:]

        nm, nd = int(m), int(d)
        if (1 <= nm <= 12 and 1 <= nd <= maxDay[nm]):
            print(f'#{tc} {y}/{m}/{d}')
        else:
            print(f'#{tc} -1')

solution()