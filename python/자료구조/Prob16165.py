
""" 실버 3. 걸그룹 마스터 준석이 """

import sys

input = sys.stdin.readline

def solution():

    N, M = map(int, input().split())        # 걸그룹 수 N, 맞혀야 할 문제의 수 M

    answer = {}

    # 걸그룹 저장
    for _ in range(N):
        name = input().strip()
        answer[name] = []
        for _ in range(int(input())):
            answer[name].append(input().strip())

    # 문제 풀기
    for _ in range(M):
        name = input().strip()
        number = int(input())

        if number:
            for t in answer.items():
                if name in t[1]:
                    print(t[0])
                    break
        else:
            for t in sorted(answer[name]):
                print(t)

solution()