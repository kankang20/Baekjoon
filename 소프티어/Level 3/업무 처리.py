
""" Lv 3. [HSAT 5회 정기 코딩 인증평가 기출] 업무 처리 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline

    H, K, R = map(int, input().split())         # 조직도의 높이 H, 말단 업무의 개수 K, 업무가 진행되는 날짜 R
    works = [deque(map(int, input().split())) for _ in range(2**H)]    # 말단 직원에 대해 대기하는 업무 (왼쪽의 말단 직원부터)
    
    # 각 직원들은 하나의 업무 리스트를 가집니다.
    workers = [deque() for _ in range(2**(H+1))]

    # 루트 = 0
    # 왼쪽 자식 노드 = 2 * n + 1   / 오른쪽 자식 노드 = 2 * n + 2
    # 부모 노드 = (n - 1) // 2

    last_company = -1
    for idx in range(2**H-1, -1, -1):
        if works[idx]:    # 해야 할 업무가 남아있다면
            workers[last_company].append(works[idx].popleft())
        last_company -= 1

    answer = 0
    for day in range(1, R+2):

        if workers[0]:
            answer += workers[0].popleft()

        for company in range(2**H):
            # 홀수 번째 날에는 왼쪽 부하 직원, 짝수 번째 날에는 오른쪽 부하 직원    
            work_company = (2 * company + 1) if day % 2 else (2 * company + 1)
            if workers[work_company]:
                workers[company].append(workers[work_company].popleft())

        # 말단 직원은 하루에 하나의 업무를 처리한다
        last_company = -1
        for idx in range(2**H-1, -1, -1):
            if works[idx]:    # 해야 할 업무가 남아있다면
                workers[last_company].append(works[idx].popleft())
            last_company -= 1

    return answer

print(solution())