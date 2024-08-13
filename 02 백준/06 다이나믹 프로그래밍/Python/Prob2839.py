
"""
title  : 2839. 설탕 배달 (Silver 4)
time   : 44ms        112ms
memory : 31256KB     114328KB
"""

N = int(input())        # 배달해야 하는 설탕 무게

def solution():

    table = [0, 0, 0, 1, 0, 1]   # 0, 1, 2, 3, 4, 5

    for idx in range(6, N+1):

        table.append(table[idx-3] + 1 if table[idx-3] else 0)           # 3
        temp = table[idx-5] + 1 if table[idx-5] else 0                  # 5

        if table[idx] and temp:
            table[idx] = min(temp, table[idx])
        elif not table[idx]:
            table[idx] = temp

    return table[N]

print(-1 if not solution() else solution())