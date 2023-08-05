
""" 골드 5. 두 용액 """

import sys

N = int(sys.stdin.readline())                       # 전체 용액의 수
S = list(map(int, sys.stdin.readline().split()))    # 각 용액의 특성값

M = []
P = []

for i in S:
    M.append(i) if i < 0 else P.append(i)

if not M:
    P.sort()
    print(P[0], P[1])
elif not P:
    M.sort()
    print(M[-2], M[-1])
else:
    answer = sys.maxsize
    number = ()

    for m in M:
        for p in P:
            count = abs(m + p)
            if count < answer:
                answer = count
                number = (m, p)
        
    print(number[0], number[1])