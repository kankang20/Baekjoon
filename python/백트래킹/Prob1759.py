
""" 골드 5. 암호 만들기 """

import sys
from itertools import combinations

def solution():
    input = sys.stdin.readline

    L, C = map(int, input().split())                # 암호를 구성하는 알파벳 개수 L, 문자 개수 C
    alp = sorted(list(input().split()))

    check = ['a', 'e', 'i', 'o', 'u']

    def isPossible(word:str):
        count = 0
        for w in word:
            if w in check:
                count+=1
        return True if 1 <= count <= L-2 else False
    
    for temp in list(combinations(alp, L)):
        word = "".join(temp)
        if (isPossible(word)):
            print(word)

solution()