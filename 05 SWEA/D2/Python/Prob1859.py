
"""
title  : 1859. 백만 장자 프로젝트 (D2)
time   : 1188ms
memory : 208092kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        N = int(input())
        price = list(map(int, input().split()))

        maxPrice = price[-1]
        answer = 0

        for p in price[::-1]:

            if (p < maxPrice):
                answer += (maxPrice - p)
            else:
                maxPrice = p

        print(f'#{tc} {answer}')    

solution()