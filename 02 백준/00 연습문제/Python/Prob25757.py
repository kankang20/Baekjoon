
"""
title  : 25757. 임스와 함께하는 미니게임 (Silver 5)
time   : 76ms       152ms
memory : 42388KB    117980KB
"""

import sys

def solution():
    input = sys.stdin.readline

    game = list(input().rstrip().split())
    
    name = set()
    for _ in range(int(game[0])):
        name.add(input().rstrip())

    if game[1] == 'Y':
        return len(name)
    elif game[1] == 'F':
        return len(name) // 2
    elif game[1] == 'O':
        return len(name) // 3

print(solution())