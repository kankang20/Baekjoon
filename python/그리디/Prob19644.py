
""" 골드 4. 좀비 떼가 기관총 진지에도 오다니 """

from collections import deque
import sys

input = sys.stdin.readline
L = int(input())                                    # 기관총 진지 앞쪽의 길이
ML, MK = map(int, input().split())                  # 기관총의 유효 사거리 ML, 기관총의 1m당 살상력 MK
C = int(input())                                    # 수평 세열 지향성 지뢰의 개수


def solution(C):

    attack = [0] # 누적합
    flag = False

    for idx in range(1, L+1):
        zombie = int(input())   # 좀비

        if flag: continue

        ml = max(0, idx - ML)
        damage = attack[idx-1] - attack[ml] 

        if zombie <= damage + MK:
            attack.append(attack[idx-1] + MK)
        else:
            if C > 0 :
                C -= 1
                attack.append(attack[idx-1])
            else:
                flag = True
                
    if flag: return "NO"
    else: return "YES"


print(solution(C))