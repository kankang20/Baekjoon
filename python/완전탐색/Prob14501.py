
""" 실버 3. 퇴사 """

import sys

input = sys.stdin.readline

N = int(input())    # 퇴사 날짜
M = []              # 상담하는데 걸리는 기간, 돈
for _ in range(N):
    x, y = map(int, input().split())
    M.append((x, y))

answer = 0

def solution(day, money):

    if day > N:
        return
    
    global answer
    answer = max(money, answer)

    for idx in range(day, N):
        solution(idx + M[idx][0], money + M[idx][1])

solution(0, 0)
print(answer)