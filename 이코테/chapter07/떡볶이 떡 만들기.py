
""" 예제 7-4) 떡볶이 떡 만들기 """

"""
4 6
19 15 10 17

>> 15
"""

N, M = map(int, input().split())
cakes = list(map(int, input().split()))


def solution(start, end):
    answer = 0

    while start <= end:
        total = 0

        mid = (start + end) // 2

        for c in cakes:
            if c > mid:
                total += (c - mid)

        if total < M:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1

    return answer


print(solution(0, max(cakes)))