
"""
title  : 255904. 실습용 로봇
"""

def solution(command):
    
    x, y, d = 0, 0, 0
    
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    for com in command:
        
        if com == 'R':
            d = abs(d + 1) % 4
        elif com == 'L':
            d = abs(d + 3) % 4
        elif com == 'G':
            x += dx[d]
            y += dy[d]
        elif com == 'B':
            x -= dx[d]
            y -= dy[d]
    
    return [x, y]

print(solution("GRGLGRG"))      # [2, 2]
print(solution("GRGRGRB"))      # [2, 0]