
"""
title  : 1989. 초심자의 회문 검사 (D2)
time   : 100ms
memory : 44264kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        word = list(input().rstrip())
        answer = 0

        if word == word[::-1]:
            answer = 1

        print(f'#{tc} {answer}')

solution()