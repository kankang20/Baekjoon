
""" 실버 4. 설탕 배달 """

N = int(input())        # 배달해야 하는 설탕 무게

def solution():

    table = [0, 0, 0, 1, 0, 1]   # 0, 1, 2, 3, 4, 5

    for idx in range(6, N+1):

        table.append(table[idx-3] + 1 if table[idx-3] else 0)           # 3
        temp = table[idx-5] + 1 if table[idx-5] else 0                  # 5

        if temp:
            if table[idx]: table[idx] = min(temp, table[idx])
            else: table[idx] = temp

    return table[N] if table[N] else -1

print(solution())