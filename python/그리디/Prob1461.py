
""" 골드 4. 도서관 """

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    books = list(map(int, input().split()))

    left = []
    right = []

    for book in books:
        if book < 0:
            left.append(book)
        else:
            right.append(book)

    def move(position:list):

        answer = 0
        length, target = len(position), 0

        while target < length:

            temp, count = target, 1
            while temp < (length-1) and count < M:
                temp += 1
                count += 1

            answer += (abs(position[target]) * 2)
            target = temp + 1

        return answer, abs(position[0]) if position else 0

    left_answer, left_value = move(sorted(left))
    right_answer, right_value = move(sorted(right, reverse=True))

    return left_answer + right_answer - max(left_value, right_value)

print(solution())