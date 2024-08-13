
"""
title  : 1092. 배 (Gold 5)
time   : 576ms       164ms
memory : 32140KB     110596KB
"""

import sys

def solution():

    input = sys.stdin.readline

    N = int(input())                                    # 크레인의 개수
    crane_weight = list(map(int, input().split()))      # 각 크레인의 무게 제한
    M = int(input())                                    # 박스의 수
    box_weight = list(map(int, input().split()))        # 각 박스의 무게

    if max(crane_weight) < max(box_weight):
        return -1

    def search(crane):

        answer = -1
        start, end = 0, len(box_weight)-1

        while start <= end:
            mid = (start + end) // 2

            if crane < box_weight[mid]:
                end = mid - 1
            else:
                answer = mid
                start = mid + 1

        return answer

    crane_weight.sort(reverse=True)
    box_weight.sort()

    day = 0

    while box_weight:

        day += 1 

        for crane in crane_weight:
            temp = search(crane)
            if temp >= 0:
                box_weight.pop(temp)
                if not box_weight:
                    break

    return day

print(solution())