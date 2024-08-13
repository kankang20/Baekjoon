
"""
title  : 1543. 문서 검색 (Silver 5)
time   : 40ms       108ms
memory : 31120KB    108080KB
"""

import sys

def solution():
    input = sys.stdin.readline
    
    text = input().rstrip()         # 문서
    
    return text.count(input().rstrip())

print(solution())
