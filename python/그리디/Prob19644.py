
""" 골드 4. 좀비 떼가 기관총 진지에도 오다니 """

from collections import deque
import sys

### 입력 
input = sys.stdin.readline

L = int(input())                        # 기관총 진지 앞쪽의 길이
ML, MK = map(int, input().split())      # 기관총의 유효 사거리 ML, 기관총의 1m당 살상력 MK
C = int(input())                        # 수평 세열 지향성 지뢰의 개수

zombies = deque()                       # 좀비s
for idx in range(L):
    zombies.append(int(input()))


### 함수

def solution():
    return "YES"
    


### 실행

print(solution())
