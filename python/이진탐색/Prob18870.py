
""" 실버 2. 좌표 압축 """

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    coor = list(map(int, input().split()))

    sorted_coor = sorted(list(set(coor)))
    N = len(sorted_coor)

    def search(target:int):
        start, end = 0, N - 1
        ans = 0
        while start <= end:

            mid = (start + end) // 2
            num = sorted_coor[mid]

            if num <= target:
                start += 1
                ans = mid
            elif num > target:
                end -= 1
        
        return ans
    
    for c in coor:
        print(search(c), end=" ")
    
solution()