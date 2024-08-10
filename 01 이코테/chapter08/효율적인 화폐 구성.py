
""" 예제 8-6) 효율적인 화폐 구성 """

"""
2 15
2 
3

>> 5

3 4
3
5
7

>> -1
"""

N, M = map(int,input().split())             # 화폐 종류 개수 N, 만들어야 하는 금액 M
coin = [int(input()) for _ in range(N)]

def solution():

    d= [0] + [-1] * M
    
    for idx in range(N):
        stan = coin[idx]
        for jdx in range(stan, M+1):
            if d[jdx - stan] != -1:
                d[jdx] = min(d[jdx], d[jdx - stan] + 1)

    if d[M] == -1:
        return -1
    else:
        return d[M]

print(solution())