
""" 실버 3. 풍선 터뜨리기 """

import sys

def solution():

    input = sys.stdin.readline()
    N = int(input())                                # 풍선 개수
    ballons = list(map(int, input().split()))       # 각 풍선 안의 종이에 적혀있는 수

print(solution())