
""" 브론즈 3. ZOAC 4 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline
    
    R, C, N, M = map(int, input().split())
    
    def calculate():
        dr = [0, N+1, N+1]
        dc = [M+1, 0, M+1]
        
        q = deque()
        q.append((0, 0))

        total = set((0, 0))
        while q:
            r, c = q.popleft()

            for d in range(3):
                nr = r + dr[d]
                nc = c + dc[d]
                if 0 <= nr < R and 0 <= nc < C:
                    q.append((nr, nc))
                    total.add((nr, nc))
        
        return len(total)
    
    return calculate()

print(solution())