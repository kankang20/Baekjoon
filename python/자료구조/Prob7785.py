
""" 실버 5. 회사에 있는 사람 """

import sys

def solution():

    N = int(sys.stdin.readline())        # 로그에 기록된 출입 기록 수

    answer = {}

    for _ in range(N):
        name, state = sys.stdin.readline().split()
        if state == 'enter':
            answer[name] = 0
        else:
            answer.pop(name)

    for name in sorted(answer.keys(), reverse=True):
        print(name)
        
solution()