
"""
title  : 1343. 폴리오미노 (Silver 5)
time   : 40ms       112ms
memory : 31256KB    113112KB
"""

board = input()

answer = board.replace("XXXX", "AAAA")
answer = answer.replace("XX", "BB")

if "X" in answer:
    print(-1)
else:
    print(answer)