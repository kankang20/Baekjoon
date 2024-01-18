
""" 골드 4. 타일 채우기 """

def solution():
    
    N = int(input())

    if N % 2 == 1:
        return 0
    
    table = {2:3}

    for i in range(4, N+1, 2):
        count = table[i-2] * 3
        for j in range(i-4, 0, -2):
            count += table[j] * 2
        table[i] = count + 2

    return table[N]

print(solution())