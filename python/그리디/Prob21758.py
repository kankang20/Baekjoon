
""" 골드 5. 꿀 따기 """

import sys

def solution():

    N = int(sys.stdin.readline())                            # 장소 수
    Honey = list(map(int, sys.stdin.readline().split()))     # 각 장소에서 딸 수 있는 꿀의 양

    answer = 0

    for idx in range(N):
        
        count = 0

        if idx == 0:
            temp = count = sum(Honey[:-2]) * 2
            for i in range(N-3, 1, -1):
                temp += (Honey[i+1] - Honey[i] * 2)
                count = max(count, temp) 
        elif idx == N-1:
            temp = count = sum(Honey[2:]) * 2
            for i in range(2, N-1):
                temp += (Honey[i-1] - Honey[i] * 2)
                count = max(count, temp)
        else:
            count = sum(Honey[1:idx+1]) + sum(Honey[idx:N-1])

        answer = max(answer, count)

    print(answer)

if __name__ == '__main__':
    solution()
