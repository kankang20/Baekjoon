
""" 실버 3. 발머의 피크 이론 """

import sys

def solution():
    input = sys.stdin.readline

    N, L = map(int, input().split())
    drink = list(map(int, input().split()))

    total = 0
    answer = 0
    for idx in range(N):
        total += drink[idx]
        if L <= idx:
            total -= drink[idx-L]
        if 129 <= total <= 138:
            answer += 1

    return answer

print(solution())