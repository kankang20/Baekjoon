
"""
title  : 2866. 문자열 잘라내기 (Gold 5)
time   : 504ms       616ms
memory : 39424KB     184292KB
"""

import sys

def solution():
    input = sys.stdin.readline

    R, C = map(int, input().split())
    word = [list(input().rstrip()) for _ in range(R)]
    
    check = set()
    for c in range(C):
        check.add("".join([word[r][c] for r in range(R)]))

    answer = 0
    for _ in range(1, R):
        temp = set()
        for _ in range(C):
            w = check.pop()[1:]
            if w in temp:
                return answer
            temp.add(w)
        check = temp
        answer += 1

    return R-1

print(solution())