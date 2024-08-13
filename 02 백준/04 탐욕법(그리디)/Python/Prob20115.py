
"""
title  : 20115. 에너지 드링크 (Silver 3)
time   : 96ms       160ms
memory : 42036KB    125104KB
"""

import sys

def solution():
    
    input = sys.stdin.readline
    N = int(input())                            # 에너지 드링크 수
    drinks = list(map(int, input().split()))    # 각 에너지 드링크의 양

    drinks.sort(reverse=True)
    answer = drinks[0] + sum(((drink / 2) for drink in drinks[1:]))

    return answer

print(solution())