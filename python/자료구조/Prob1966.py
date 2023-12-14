
""" 실버 3. 프린터 큐 """

import sys
from collections import deque

def solution():

    input = sys.stdin.readline

    T = int(input())     # 테스트케이스

    for _ in range(T):

        N, M = map(int, input().split())            # 문서의 개수 N, 궁금한 문서의 위치(인덱스) M
        Papers = list(map(int, input().split()))    # 문서의 중요도
        papers = deque([(idx, p) for (idx, p) in enumerate(Papers)])

        priority = sorted(Papers, reverse=True)
        pdx = 0

        answer = 1

        while papers:

            temp = papers.popleft()

            if priority[pdx] == temp[1]:
                if temp[0] == M:
                    break
                answer += 1
                pdx += 1
            else:
                papers.append(temp)

        print(answer)


solution()