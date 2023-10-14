
""" 골드 5. 배 """

import sys

input = sys.stdin.readline

def solution():

    N = int(input())                                    # 크레인의 개수
    crane_weight = list(map(int, input().split()))      # 각 크레인의 무게 제한
    M = int(input())                                    # 박스의 수
    box_weight = list(map(int, input().split()))        # 각 박스의 무게

    # 만약 모든 박스를 배로 옮길 수 없으면 
    if max(crane_weight) < max(box_weight):
        return -1
    
    # 박스를 배로 옮길 수 있으면
    crane_weight.sort(reverse=True)
    box_weight.sort()

    answer = 0
    
    while box_weight:

        for crane in crane_weight:
            
            idx = len(box_weight)-1

            while box_weight and idx >= 0:
                if box_weight[idx] <= crane:
                    box_weight.pop(idx)
                    break
                idx -= 1

        answer += 1

    return answer

print(solution())

    