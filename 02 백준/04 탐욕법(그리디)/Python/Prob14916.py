
"""
title  : 14916. 거스름돈 (Silver 5)
time   : 40ms       116ms
memory : 31256KB    108080KB
"""

N = int(input())    # 거스름돈

for five in range(N // 5, -1, -1):

    charge = N - five * 5

    if charge % 2 == 0:
        print(five + charge // 2)
        break

else:
    print(-1)
