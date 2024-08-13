
"""
title  : 11508. 2+1 세일 (Silver 4)
time   : 4012ms       228ms
memory : 35500KB      117028KB
"""

N = int(input())    # 유제품의 수

products = [int(input()) for _ in range(N)]     # 각 유제품의 가격

products.sort(reverse=True)

answer = 0

for num in range(0,len(products),3):
    
    answer += sum(products[num:num+2])

print(answer)