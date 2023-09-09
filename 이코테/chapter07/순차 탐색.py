
""" 예제 7-1) 순차 탐색 """

def sequential_search1(n, target, array):

    for idx in range(n):
        if array[idx] == target:
            return idx + 1
        

def sequential_search2(target, array):
    idx = 0
    for a in array:
        if a == target:
            return idx + 1
        idx += 1
        

print("입력할 문자열의 개수와 개수만큼의 문자열을 입력하세요")
array = list(input().split())                       # 5 H W D Q I

print("찾을 문자열을 입력하세요.")
target = input()                                    # Q


print("1. 찾은 문자열의 인덱스 = ", sequential_search1(int(array[0]), target, array[1:]))
print("2. 찾은 문자열의 인덱스 = ", sequential_search2(target, array[1:]))