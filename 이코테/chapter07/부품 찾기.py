
""" 예제 7-3) 부품 찾기 """

N = int(input())
products = list(map(int, input().split()))

M = int(input())    
orders = list(map(int, input().split()))

# 계수 정렬 Count Sort를 위한 
count = [0] * 1000001
for p in products:
    count[p] = 1

# Set 자료형을 위한
set_products = set(products)


def binary_search(target, start, end):

    while start <= end:
        
        mid = (start + end) // 2

        if products[mid] == target:
            return "yes"
        elif products[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    return "no"


def count_sort(target):
    
    if count[target]:
        return "yes"
    else: 
        return "no"
    

def simple_set(target):
    if target in set_products:
        return "yes"
    else:
        return "no"


print("이진 탐색 : ", end = "")
for order in orders:
        print(binary_search(order, 0, N-1), end = " ")

print()
print("계수 정렬 : ", end = "")
for order in orders:
        print(count_sort(order), end = " ")

print()
print("Set 자료형 : ", end = "")
for order in orders:
        print(simple_set(order), end = " ")

