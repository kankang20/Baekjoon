
""" Lv 33. 우물 안 개구리 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())    # 회원 수 N, 친분관계 수 M

    weight = [0] + list(map(int, input().split()))
    selected = [True for _ in range(N+1)]

    answer = N
    for _ in range(M):

        num1, num2 = map(int, input().split())

        if weight[num1] < weight[num2]:
            if selected[num1]:
                selected[num1] = False
                answer -= 1
        elif weight[num1] > weight[num2]:
            if selected[num2]:
                selected[num2] = False
                answer -= 1
        else:  
            if selected[num1]:
                answer -= 1
                selected[num1] = False
            if selected[num2]:
                answer -= 1
                selected[num2] = False 

        print(selected)
    
    return answer

print(solution())