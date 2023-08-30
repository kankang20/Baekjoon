
""" 예제 6-5) 위에서 아래로 """

N = int(input())
array = [int(input()) for _ in range(N)]

### 기본 라이브러리 sort
array1 = array[:]

array1.sort(reverse=True)
print("기본 라이브러리 sort = ", array1)

### 기본 라이브러리 sorted
array2 = array[:]

answer = sorted(array2, reverse=True)
print("기본 라이브러리 sorted = ",answer)

### 선택 정렬 
array3 = array[:]

def selection(N, array):
    
    for i in range(N):
        min = i

        for j in range(i+1, N):
            if array[min] < array[j]:
                min = j

        array[i], array[min] = array[min], array[i]

    return array

answer = selection(N, array3)
print("선택 selection 정렬 = ", answer)

### 삽입 정렬
array4 = array[:]

def insertion(N, array):

    for i in range(1, N):
        for j in range(i, 0, -1):

            if array[j] > array[j-1]:
                array[j], array[j-1] = array[j-1], array[j]
            else:
                break

    return array

answer = insertion(N, array4)
print("삽입 insertion 정렬 = ", answer)

### 퀵 정렬
array5 = array[:]

def quick(array):
    
    if len(array) <= 1:
        return array
    
    pivot = array[0]
    tail = array[1:]

    left = [x for x in tail if x <= pivot]
    right = [x for x in tail if x > pivot]

    return quick(right) + [pivot] + quick(left)

answer = quick(array5)
print("퀵 qucik 정렬 = ", answer)

### 계수 정렬
array6 = array[:]

def count(array):

    select = [0] * (max(array) + 1)

    for a in array:
        select[a] += 1

    answer = []

    for i in range(len(select)):
        for j in range(select[i]):
            answer.append(i)

    return answer

answer = count(array)
print("계수 count 정렬 = ", answer[::-1])