
""" 실버 4. 설탕 배달 """

N = int(input())        # 배달해야 하는 설탕 무게

def solution(N):
    answer = 0

    while N >= 3:
        if N % 5 == 0:
            answer += (N//5)
            N %= 5
        else:
            answer += 1
            N -= 3

    return -1 if N else answer

print(solution(N))