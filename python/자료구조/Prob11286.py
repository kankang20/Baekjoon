
""" 실버 1. 절댓값 힙 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input().rstrip())

    answer = []
    for _ in range(N):

        command = int(input().rstrip())

        if answer > 0:
            heappush(answer, (command, 1))      # 0이면 마이너스, 1이면 플러스
        elif answer < 0:
            heappush(answer, (-command, 0))
        else:

            if answer:
                heappop(answer)
            else:
                print(0)


solution()