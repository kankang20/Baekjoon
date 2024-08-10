
"""
title  : 1713. 후보 추천하기 (Silver 1)
time   : 40ms      116ms
memory : 31120KB   109240KB
"""

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                            # 사진틀의 개수
    total_count = int(input())                  # 전체 학생의 총 추천 횟수
    numbers = list(map(int, input().split()))   # 추천 순서

    answer = {}     # 학생 번호 : 추천 횟수

    for idx in range(total_count):

        num = numbers[idx]  # 추천하는 학생 번호

        if num in answer.keys():
            answer[num] = answer[num] + 1
            continue

        if len(answer) == N:
            answer.pop(remove(answer))
        answer[num] = 1

    for num in sorted(answer.keys()):
        print(num, end=" ")


def remove(answer: dict):
    
    min_value = min(answer.values())

    for idx in answer.keys():
        if answer[idx] == min_value:
            return idx
    

solution()