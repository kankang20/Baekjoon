
""" 브론즈 1. 피보나치 수 2 """

N = int(input())        # N번째 피보나치 수

def solution():

    table = [0, 1]

    for idx in range(2, N+1):
        table.append(table[idx-2] + table[idx-1])
    
    return table[N]

print(solution())