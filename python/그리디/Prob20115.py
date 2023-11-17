
""" 실버 3. 에너지 드링크 """

import sys

def solution():
    
    input = sys.stdin.readline
    N = int(input())                            # 에너지 드링크 수
    drinks = list(map(int, input().split()))    # 각 에너지 드링크의 양

    drinks.sort(reverse=True)
    answer = drinks[0] + sum(((drink / 2) for drink in drinks[1:]))

    return answer

print(solution())