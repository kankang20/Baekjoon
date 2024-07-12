
""" 골드 4. 연구소 2 """

import sys

def solution():
    input = sys.stdin.readline

    R, C = map(int, input().split())
    
    board = []
    for _ in range(R):
        board.append(list(map(int, input().split())))

print(solution())