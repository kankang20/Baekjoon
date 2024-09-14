
"""
title  : 5874. 소를 찾아라 (Silver 3)
time   : 40ms        92ms
memory : 31120KB     109260KB
"""

import sys

def solution():

    input = sys.stdin.readline

    board = input().rstrip()

    count = 0
    answer = 0
    for i in range(len(board)-1):
        
        if board[i] == ")" and board[i+1] == ")":
            answer += count
        elif board[i] == "(" and board[i+1] == "(":
            count += 1

    return answer

print(solution())