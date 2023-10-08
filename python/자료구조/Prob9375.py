
""" 실버 3. 패션왕 신해빈 """

import sys

input = sys.stdin.readline

def solution():

    N = int(input())    # 의상 수

    answer = 1
    clothes = {}

    for _ in range(N):
        _, j = input().split()
        clothes[j] = clothes.setdefault(j, 0) + 1

    for num in clothes.values():
        answer *= (num+1)

    return answer - 1

testcase = int(input())
for _ in range(testcase):
    print(solution())