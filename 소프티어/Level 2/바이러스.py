
""" Lv 2. 바이러스 """

import sys

def solution():
    input = sys.stdin.readline

    K, P, N = map(int, input().split())     # 처음 바이러스의 수 K, 증가율 P, 총 시간 N

    return (K * (P ** N)) % 1000000007

print(solution())