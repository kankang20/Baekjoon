
""" 실버 1. 후보 추천하기 """

import sys

def solution():

    input = sys.stdin.readline
    N = int(input())                            # 사진틀의 개수
    total_count = int(input())                  # 전체 학생의 총 추천 횟수
    numbers = list(map(int, input().split()))   # 추천 순서

    answer = {}     # (학생 번호, 추천 순서) : 추천 횟수

    for idx in range(total_count):

        num = numbers[idx]  # 추천하는 학생 번호

        # if num in 


print(solution())