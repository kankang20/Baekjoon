
""" 실버 2. 출석체크 """

import sys

def solution():

    input = sys.stdin.readline
    N, K, Q, M = map(int, input().split())          # 학생 수 N, 졸고 있는 학생 수 K, 출석코드 보낼 학생 수 Q, 주어질 구간의 수 M
    k_student = list(map(int, input().split()))     # 졸고 있는 학생의 입장 번호
    q_student = list(map(int, input().split()))     # 출석 코드를 받을 학생의 입장 번호

    student = [0] * (N+3)

    for k in k_student:
        student[k] = -1

    for q in q_student:
        if student[q] == 0:
            idx = q
            while idx < N+3:
                if student[idx] == 0:
                    student[idx] = 1
                idx += q

    for _ in range(M):
        S, E = map(int, input().split())                # 구간의 범위 S, E
        
        answer = 0
        for idx in range(S, E+1):
            if student[idx] < 1:
                answer += 1

        print(answer)

solution()