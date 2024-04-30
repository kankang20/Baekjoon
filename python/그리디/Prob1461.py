
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
            while temp < (length-1) and position[temp] * position[temp+1] > 0 and count < M:
                temp += 1
                count += 1

            answer += max(abs(position[target]), abs(position[temp])) * 2
            target = temp + 1

        return answer
    
    left.sort()
    right.sort(reverse=True)

    answer = move(left)
    answer += move(right)

    if left and right:
        return answer - max(abs(left[0]), right[0])
    elif left:
        return answer + left[0]
    elif right:
        return answer - right[0]

print(solution())