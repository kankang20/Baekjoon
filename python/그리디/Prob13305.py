
""" 실버 3. 주유소 """

N = int(input())    # 도시의 개수

# 도로의 길이
Length = list(map(int, input().split()))    # 도로의 길이

# 주유소의 리터랑 가격
E1 = [num for num in range(N)]
E2 = list(map(int, input().split()))   

Expense = dict(zip(E1, E2))
Expense = sorted(Expense.items(), key = lambda item: item[1])

# 지불 가능한 도로인지 확인 
check = [False for _ in range(N-1)]   

for key, value in Expense:
    print(key, value)

