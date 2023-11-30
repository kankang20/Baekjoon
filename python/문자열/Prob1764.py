
""" 실버 4. 듣보잡 """

import sys

def solution():

    input = sys.stdin.readline
    N, M = map(int, input().split())        # 듣도 못한 사람 N, 보도 못한 사람 M
    
    check = set()

    for _ in range(N):
        check.add(input().rstrip())
    
    answer = []
    for _ in range(M):
        name = input().rstrip()
        if name in check:
            answer.append(name)

    print(len(answer))
    for ans in sorted(answer):
        print(ans)

solution()