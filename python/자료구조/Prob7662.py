
""" 골드 4. 이중 우선순위 큐 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline

    T = int(input())

    for _ in range(T):

        Operations = int(input())       # 연산 개수

        min_heap = []       # 최소힙 (작은 수 먼저)
        max_heap = []       # 최대힙 (큰 수 먼저)

        numbers = set()

        for _ in range(Operations):

            command = input().split()

            if command[0] == "I":

                number = int(command[1])

                heappush(min_heap, number)
                heappush(max_heap, -number)

                numbers.add(number)

            elif command[0] == "D":

                if not numbers:
                    continue

                if command[1] == "1":       # 최댓값 삭제
                    while -max_heap[0] not in numbers:
                        heappop(max_heap)
                    numbers.remove(-heappop(max_heap))

                elif command[1] == "-1":    # 최솟값 삭제
                    while min_heap[0] not in numbers:
                        heappop(min_heap)
                    numbers.remove(heappop(min_heap))
        
        if not numbers:
            print("EMPTY")
        else:

            while -max_heap[0] not in numbers:
                heappop(max_heap)
            max_number = -heappop(max_heap)

            while min_heap[0] not in numbers:
                heappop(min_heap)
            min_number = heappop(min_heap)

            print(max_number, min_number)

solution()