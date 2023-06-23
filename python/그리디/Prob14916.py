
""" 실버 5. 거스름돈 """

N = int(input())    # 거스름돈

for five in range(N // 5, -1, -1):

    charge = N - five * 5

    if charge % 2 == 0:
        print(five + charge // 2)
        break

else:
    print(-1)
