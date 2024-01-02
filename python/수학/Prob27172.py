
""" 골드 5. 수 나누기 게임 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())                                # 플레이어의 수
    cards = list(map(int, input().split()))         # 각 플레이어가 가지고 있는 카드에 적힌 정수

    max_card = max(cards)
    answer = [0] * (max_card + 1)
    check = [False] * (max_card + 1)

    for card in cards:
        check[card] = True

    for card in cards:
        for num in range(2*card, max_card+1, card):
            if check[num]:
                answer[num] -= 1
                answer[card] += 1
    
    for card in cards:
        print(answer[card], end=" ")

solution()