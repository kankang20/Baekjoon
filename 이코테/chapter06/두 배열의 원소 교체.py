
""" 예제 6-7) 두 배열의 원소 교체 """

N, K = map(int, input().split())        # 각 배열의 원소 개수 N, 바꿔치기 연산 수행 횟수 K
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

for k in range(K):

    if A[k] < B[k]:
        A[k], B[k] = B[k], A[k]
    else:
        break

print(sum(A))