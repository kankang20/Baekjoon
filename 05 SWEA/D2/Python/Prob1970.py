
"""
title  : 1970. 쉬운 거스름돈 (D2)
time   : 114ms
memory : 43756kb
"""

def solution():

    price = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

    T = int(input())
    for tc in range(1, T+1):

        target = int(input())
        answer = []

        for p in price:
            answer.append(str(target // p))
            target %= p

        print(f'#{tc}\n{" ".join(answer)}')

solution()