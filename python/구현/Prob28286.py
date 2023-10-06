
""" 실버 2. 재채점을 기다리는 중 """

N, K = map(int, input().split())            # 문제 수 N, 밀고 당길 수 있는 최대 횟수 K
C = list(map(int, input().split()))         # 각 문제의 정답을 나타내는 정수
P = list(map(int, input().split()))         # 민규가 OMR 카드에 기입한 답안

answer = 0
    
def check(array, idx, K):
    global answer
    answer = max(answer, sum(C[i] == array[i] for i in range(N)))

    if K:
        for idx in range(N):
            check(array[:idx] + array[idx+1:] + [0], idx+1, K-1)
            check(array[:idx] + [0] + array[idx:-1], idx+1, K-1)

def solution():
    check(P, 0, K)
    return answer

print(solution())