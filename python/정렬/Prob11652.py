
""" 실버 4. 카드 """

import sys

def solution():
    input = sys.stdin.readline

    numbers = dict()
    ansNum = 0
    ansCnt = 0

    N = int(input())

    for _ in range(N):
        num  = int(input())
        temp = numbers.get(num, 0) + 1

        if ansCnt == temp and num < ansNum:
            ansNum = num
        elif ansCnt < temp:
            ansNum = num
            ansCnt = temp

        numbers[num] = temp

    return ansNum

print(solution())