
""" 예제 8-1) 피보나치(재귀) """

# 메모제이션
dp = [0] * 100

def fibo(x):

    print('f(' + str(x) + ')', end=' ')
    
    if x == 1 or x == 2:
        return 1
    
    if dp[x] != 0:
        return dp[x]
    
    dp[x] = fibo(x-1) + fibo(x-2)
    return dp[x]

print(fibo(6))
# print(fibo(99))