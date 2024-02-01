
""" 실버 4. 제로 """

import sys

def solution():
    input = sys.stdin.readline

    K = int(input())        # 정수 개수

    money = []
    for _ in range(K):
        number = int(input())

        if number:
            money.append(number)
        else:
            money.pop()

    return sum(money)

print(solution())