
""" 골드 2. 놀이 공원 """

import sys

input = sys.stdin.readline
N, M = map(int, input())                    # 아이들의 수 N, 1인승 놀이기구 종류 M
clock = list(map(int, input().split))       # 각 놀이기구의 운행 시간 

def solution():

    """
        (1, 7) (2, 8) (3, 9) (4, 7) (5, 8)

        (1, 3) (2, 2)
    """