
""" 실버 2. 재채점을 기다리는 중 """

N, K = map(int, input().split())            # 문제 수 N, 밀고 당길 수 있는 최대 횟수 K
C = list(map(int, input().split()))         # 각 문제의 정답을 나타내는 정수
P = list(map(int, input().split()))         # 민규가 OMR 카드에 기입한 답안

answer = 0

def pull(idx, array):     # 당기기
    temp = array[:idx] + array[idx+1:] + [0]
    return temp

def push(idx, array):     # 밀기
    temp = array[:idx] + [0] + array[idx:-1]
    return temp

def calculate_sum(array):
    count = 0
    for i in range(N):
        if C[i] == array[i]:
            count += 1
    return count
    
def check(array, K):
    global answer
    answer = max(answer, calculate_sum(array))

    if K:
        for idx in range(N):
            check(pull(idx, array), K-1)
            check(push(idx, array), K-1)

def solution():
    check(P, K)
    return answer

print(solution())