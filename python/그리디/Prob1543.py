
""" 실버 5. 문서 검색 """

import sys

def solution():

    input = sys.stdin.readline

    text = input().rstrip()         # 문서
    word = input().rstrip()         # 검색하고 싶은 단어

    return text.count(word)

print(solution())