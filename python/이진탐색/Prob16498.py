
""" 골드 5. 작은 벌점 """

import sys

def solution():

    input = sys.stdin.readline

    A, B, C = map(int, input().split())
    
    cards = []
    for _ in range(3):
        cards.append(list(map(int, input().split())))

    answer = 1e9

    for num1 in cards[0]:
        for num2 in cards[1]:
            for num3 in cards[2]:
                answer = min(max(num1, num2, num3) - min(num1, num2, num3), answer)

    print(answer)

solution()