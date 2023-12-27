
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

        numbers = dict()

        for _ in range(Operations):

            command = input().split()

            if command[0] == "I":

                number = int(command[1])

                heappush(min_heap, number)
                heappush(max_heap, -number)
            
                numbers[number] = numbers.get(number, 0) + 1

            elif command[0] == "D":

                if sum(numbers.values()) == 0:
                    continue

                if command[1] == "1":       # 최댓값 삭제
                    while not numbers[-max_heap[0]]:
                        heappop(max_heap)
                    numbers[-heappop(max_heap)] -= 1

                elif command[1] == "-1":    # 최솟값 삭제
                    while not numbers[min_heap[0]]:
                        heappop(min_heap)
                    numbers[heappop(min_heap)] -= 1
        
        if sum(numbers.values()) == 0:
            print("EMPTY")
        else:

            while not numbers[-max_heap[0]]:
                heappop(max_heap)
            max_number = -heappop(max_heap)

            while not numbers[min_heap[0]]:
                heappop(min_heap)
            min_number = heappop(min_heap)

            print(max_number, min_number)

solution()