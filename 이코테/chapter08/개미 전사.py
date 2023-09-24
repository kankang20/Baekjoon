
""" 예제 8-4) 개미 전사 """

"""
4 
1 3 1 5

>> 8
"""

N = int(input())                            # 식량창고의 개수
K = list(map(int, input().split()))      # 식량창고에 저장된 식량의 개수

def solution():

    d = []
    d.append(K[0])
    d.append(max(K[0], K[1]))
    
    for idx in range(2, N):
        number = max(d[idx-1], d[idx-2] + K[idx])
        d.append(number)
    
    return d[N-1]

print(solution())