
"""
title  : 1966. 숫자를 정렬하자 (D2)
time   : 113ms
memory : 43776kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N = int(input())
        number = sorted(list(map(int, input().split())))

        answer = " ".join(list(map(str, number)))

        print(f'#{tc} {answer}')

solution()