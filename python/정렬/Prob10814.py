
""" 실버 5. 나이순 정렬 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())    # 회원 수

    people = []
    for idx in range(N):
        age, name = input().rstrip().split()
        people.append((int(age), idx, name))

    people.sort(key=lambda x : (x[0], x[1]))
    
    for p in people:
        print(p[0], p[2])

solution()