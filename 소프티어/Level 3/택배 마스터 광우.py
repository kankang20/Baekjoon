
""" Lv 3. 택배 마스터 광우 """

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, M, K = map(int, input().split())         # 레일의 개수 N, 택배 바구니의 무게 M, 일의 시행 횟수 K
    weight = list(map(int, input().split()))    # 택배 레일의 전용 무게

    answer = 1e9
    for rail in list(permutations(weight, N)):

        weight = 0
        idx, count = 0, 0
        while count < K:

            temp_weight = rail[idx % N]
            while temp_weight + rail[(idx+1) % N] <= M:
                idx += 1
                temp_weight += rail[idx % N]

            weight += temp_weight

            if weight > answer:
                break

            idx += 1
            count += 1

        answer = min(answer, weight)

    return answer

print(solution())