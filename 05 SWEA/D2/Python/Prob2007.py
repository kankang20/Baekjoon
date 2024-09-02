
"""
title  : 2007. 패턴 마디의 길이 (D2)
time   : 102ms
memory : 44800kb
"""

def solution():

    T = int(input())
    for tc in range(1, T+1):

        pattern = input().rstrip()
        target = 1
        
        while target < 10:

            while pattern[0] != pattern[target]:
                target += 1

            if pattern[:target] == pattern[target:target*2]:
                print(f'#{tc} {target}')
                break

            target += 1
            
solution()