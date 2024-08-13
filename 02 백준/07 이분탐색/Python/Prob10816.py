
"""
title  : 10816. 숫자 카드 2 (Silver 4)
time   : 596ms         524ms
memory : 137160KB      258224KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())                            # 숫자 카드 개수
    card = list(map(int, input().split()))      # 숫자 카드

    M = int(input())                            # 구해야 하는 숫자 개수
    number = list(map(int, input().split()))    # 개수를 구해야 하는 숫자 

    check = dict()
    for c in card:
        check[c] = check.get(c, 0) + 1
    
    answer = []
    for num in number:
        answer.append(str(check.get(num, 0)))

    return " ".join(answer)

print(solution())