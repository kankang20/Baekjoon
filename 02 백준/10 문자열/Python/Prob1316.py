
"""
title  : 1316. 그룹 단어 체커 (Silver 5)
time   : 40ms        108ms
memory : 31120KB     109240KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                # 단어의 개수
    words = []                      # 단어들
    for _ in range(N):
        words.append(input())

    answer = 0

    for word in words:
        answer += group_word(word)
    
    return answer

def group_word(word):

    check = []
    idx = 0

    while idx < len(word):

        temp = word[idx]

        if temp in check:
            return 0
        
        check.append(temp)
        
        while idx < len(word) and temp == word[idx]:
            idx += 1
    
    return 1

print(solution())