
""" 골드 5. 가장 긴 짝수 연속한 부분 수열 (large) """

import sys

def solution():

    input = sys.stdin.readline
    N, K = map(int, input().split())
    numbers = list(map(int, input().split()))
    
    start, end, = 0, 0
    length_even, count_odd = 0, 0

    if numbers[start] % 2 == 0:
        length_even += 1
    else:
        count_odd += 1

    answer = length_even

    while end < N-1:

        end += 1

        if numbers[end] % 2 == 0:
            length_even += 1
        else:
            count_odd += 1

        if K < count_odd:

            while numbers[start] % 2 == 0:
                length_even -= 1
                start += 1

            count_odd -= 1
            start += 1

        answer = max(answer, length_even)

    return answer


print(solution())