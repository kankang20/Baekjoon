
""" 실버 2. 잃어버린 괄호 """

import sys

def solution():
    input = sys.stdin.readline

    N = input().rstrip().split("-")      # 문제의 핵심은 - 

    answer = sum(map(int, N[0].split("+")))
    for nm in N[1:]:
        answer -= sum(map(int, nm.split("+")))

    return answer

print(solution())