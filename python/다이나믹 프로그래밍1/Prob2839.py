
""" 실버 4. 설탕 배달 """

N = int(input())        # 배달해야 하는 설탕 무게

def solution():

    table = [float('inf') for _ in range(6)]   # 0, 1, 2, 3, 4, 5
    table[3], table[5] = 1, 1

    for idx in range(6, N+1):
        table.append(min(table[idx-3], table[idx-5]) + 1)

    return -1 if table[N] == float('inf') else table[N]

print(solution())