
""" 실버 5. 그룹 단어 체커 """

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                # 단어의 개수
    words = []                      # 단어들
    for _ in range(N):
        words.append(input())

print(solution())