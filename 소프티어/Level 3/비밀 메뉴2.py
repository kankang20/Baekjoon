
""" Lv 3. [21년 재직자 대회 본선] 비밀 메뉴2 """

import sys

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())     

    target1 = list(map(int, input().split()))
    target2 = list(map(int, input().split()))

    answer = 0
    for idx in range(N):

        jdx = 0

        while jdx < M:

            while jdx < M and target1[idx] != target2[jdx]:
                jdx += 1

            if jdx >= M:
                break

            count = 0
            c1, c2 = idx, jdx
            while c1 < N and c2 < M and target1[c1] == target2[c2]:
                count += 1
                c1 += 1
                c2 += 1
            
            answer = max(answer, count)
            jdx += 1

    return answer    

print(solution())