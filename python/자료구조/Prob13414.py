
""" 실버 3. 수강신청 """

import sys

input = sys.stdin.readline

def solution():

    K, L = map(int, input().split())        # 과목 수강 가능 인원 K, 대기목록 길이 L
    answer = {}
    idx = 0

    for _ in range(L):
        number = input().strip()
        answer[number] = idx
        idx += 1
    
    for num in sorted(answer.items(), key=lambda x : x[1])[:K]:
        print(num[0])

solution()