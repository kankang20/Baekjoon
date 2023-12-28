
""" 골드 4. 이중 우선순위 큐 """

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline

    for _ in range(int(input())):

        Operations = int(input())       # 연산 개수

        min_heap = []                       # 최소힙 (작은 수 먼저)
        max_heap = []                       # 최대힙 (큰 수 먼저)
        selected = [False] * Operations

        for idx in range(Operations):

            command = input().split()

            if command[0] == "I":
                number = int(command[1])
                heappush(min_heap, (number, idx))
                heappush(max_heap, (-number, idx))
            
            elif command[0] == "D":

                if command[1] == "-1":          # 최솟값 삭제
                    # while min_heap and selected[min_heap[0][1]]:
                    #     heappop(min_heap)
                    if min_heap:
                        selected[heappop(min_heap)[1]] = True
                    
                elif command[1] == "1":         # 최댓값 삭제
                    # while max_heap and selected[max_heap[0][1]]:
                    #     heappop(max_heap)
                    if max_heap:
                        selected[heappop(max_heap)[1]] = True

            while min_heap and selected[min_heap[0][1]]:
                heappop(min_heap)
            while max_heap and selected[max_heap[0][1]]:
                heappop(max_heap)

            # print("max_heap = ", max_heap)
            # print("min_heap = ", min_heap)
            # print("selected = ", selected)

        if not max_heap or not min_heap:
            print("EMPTY")
        else:
            print(-max_heap[0][0], min_heap[0][0])

solution()
