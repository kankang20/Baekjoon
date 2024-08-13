
"""
title  : 1010. 다리 놓기 (Silver 5)
time   : 80ms        172ms
memory : 33376KB     114328KB
"""

import math

T = int(input())        # 테스트케이스

for _ in range(T):
    N, M = map(int, input().split())
    print(math.comb(M, N))