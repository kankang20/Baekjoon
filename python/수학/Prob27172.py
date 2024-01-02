
""" 골드 5. 수 나누기 게임 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())                                # 플레이어의 수
    cards = list(map(int, input().split()))         # 각 플레이어가 가지고 있는 카드에 적힌 정수

    answer = [0] * (N)

    for i in range(N):
        for j in range(i, N):

            if cards[i] % cards[j] == 0:
                answer[i] -= 1
                answer[j] += 1
            elif cards[j] % cards[i] == 0:
                answer[i] += 1
                answer[j] -= 1
            else:
                continue
    
    print(answer)

solution()