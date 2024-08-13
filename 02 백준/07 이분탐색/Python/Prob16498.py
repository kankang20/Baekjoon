
"""
title  : 16498. 작은 벌점 (Gold 5)
time   : 48ms       140ms
memory : 31252KB    110776KB
"""

import sys

def solution():

    input = sys.stdin.readline
    A, B, C = map(int, input().split())
    
    cards = []
    for _ in range(3):
        cards.append(sorted(list(map(int, input().split()))))

    answer = 1e9
    for a in cards[0]:
        
        b = search(cards[1], a)
        c1 = search(cards[2], a)
        c2 = search(cards[2], b)
        
        answer = min(answer, 
                     max(a, b, c1) - min(a, b, c1), 
                     max(a, b, c2) - min(a, b, c2))

    return answer

def search(card, target):

    answer = 1e9
    start, end = 0, len(card)-1

    while start <= end:

        mid = (start + end) // 2

        if abs(card[mid] - target) < abs(answer - target):
            answer = card[mid]

        if card[mid] == target:
            return card[mid]
        elif card[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return answer

print(solution())