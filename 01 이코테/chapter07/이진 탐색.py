
""" 예제 7-2) 이진 탐색 """


# 재귀 함수를 이용한 이진탐색
def binary_search1(array, target, start, end):

    if start > end:
        return None
    
    # 중간점   
    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search1(array, target, start, mid-1)
    else:
        return binary_search1(array, target, mid+1, end)
    

# 반복문을 이용한 이진탐색
def binary_search2(array, target, start, end):
    while start <= end:
        
        mid = (start + end) // 2
        
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    
    return None

N, target = list(map(int, input().split()))
array = list(map(int, input().split()))


# 재귀 함수를 이용한 이진탐색
answer1 = binary_search1(array, target, 0, N-1)

print("1.", end = " ")
if not answer1:      # None
    print("원소가 존재하지 않습니다. ")
else:
    print(answer1+1)


# 반복문을 이용한 이진탐색
answer2 = binary_search2(array, target, 0, N-1)

print("2.", end = " ")
if not answer2:      # None
    print("원소가 존재하지 않습니다. ")
else:
    print(answer2+1)