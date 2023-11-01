
""" 실버 3. 숫자 야구 """

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())        # 질문 개수

    for _ in range(N):
        number, strike, ball = map(int, input().split())


print(solution())