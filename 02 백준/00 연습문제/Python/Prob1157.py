
"""
title  : 1157. 단어 공부 (Bronze 1)
time   : 124ms      172ms
memory : 33076KB    114192KB
"""

import sys

def solution():
    input = sys.stdin.readline

    word = input().rstrip().upper()

    alp = dict()
    for w in word:
        alp[w] = alp.get(w, 0) + 1

    keys = sorted(alp.keys(), key=lambda x:alp[x], reverse=True)
    
    return keys[0] if len(keys) == 1 else ("?" if alp[keys[0]] == alp[keys[1]] else keys[0])

print(solution())