
""" 골드 5. 무한 수열 """

import sys
from collections import deque

def solution():
    
    N, P, Q = map(int, sys.stdin.readline().split())

    if N == 0:
        return 1

    table = {}
    table[0] = 1
    table[N] = 0

    q = deque()
    q.append(N)

    while q:
        now = q.popleft()
        i, j = now//P, now//Q

        if i not in table:
            q.append(i)
            table[i] = 0

        if j not in table:
            q.append(j)
            table[j] = 0

    for idx in sorted(table.keys())[1:]:
        table[idx] = table[idx//P] + table[idx//Q]

    return table[N]

print(solution())