
"""
title  : 25328. 문자열 집합 조합하기 (Silver 3)
time   : 128ms       216ms
memory : 53296KB     134176KB
"""

import itertools

def solution():

    X = input()
    Y = input()
    Z = input()
    K = int(input())

    XN = set(itertools.combinations(X, K))
    YN = set(itertools.combinations(Y, K))
    ZN = set(itertools.combinations(Z, K))

    result = list((XN & YN) | (YN & ZN) | (ZN & XN))

    if not result:
        print(-1)
    else:
        answer = []
        for i in result:
            answer.append("".join(i))

        answer.sort()

        for i in answer:
            print(i, end="\n")


if __name__ == '__main__':
    solution()