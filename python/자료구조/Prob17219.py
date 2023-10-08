
""" 실버 4. 비밀번호 찾기 """

import sys

input = sys.stdin.readline

def solution():

    N, M = map(int, input().split())    # 사이트 주소의 수 N, 비밀번호를 찾으려는 사이트 주소의 수 M

    answer = {}
    for _ in range(N):
        site, password = input().split()
        answer[site] = password

    for _ in range(M):
        site = input().strip()
        print(answer[site])

solution()