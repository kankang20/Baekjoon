
""" 골드 3. 말이 되고픈 원숭이 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    K = int(input())
    C, R = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(R)]

def bfs():
    
    dr = [-2, -1, 1, 2, 2, 1, -1, -2]
    dc = [-1, -2, -2, -1, 1, 2, 2, 1]

    q = deque()
    


print(solution())