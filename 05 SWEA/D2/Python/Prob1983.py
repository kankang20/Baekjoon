
"""
title  : 1983. 조교의 성적 매기기 (D2)
time   : 141ms
memory : 45056kb
"""

def solution():

    grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

    T = int(input())
    for tc in range(1, T+1):

        N, K = map(int, input().split())

        score = []
        for _ in range(N):
            a, b, c = map(int, input().split())
            score.append(a * 0.35 + b * 0.45 + c * 0.2)

        target = score[K-1]
        score.sort(reverse=True)
        answer = score.index(target) // (N//10)

        print(f'#{tc} {grade[answer]}')

solution()