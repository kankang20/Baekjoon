
"""
title  : 1874. 스택 수열 (Silver 2)
time   : 92ms       180ms
memory : 33096KB    11800KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 숫자 개수

    answer, numbers = [], []
    flag, count = False, 1
    for _ in range(N):

        num = int(input())

        if flag:
            continue

        if count <= num:
            for n in range(count, num+1, 1):
                answer.append("+")
                numbers.append(n)
            count = num + 1
        elif numbers[-1] != num:
            flag = True

        answer.append("-")
        numbers.pop()

    return "NO" if flag else "\n".join(answer)

print(solution())