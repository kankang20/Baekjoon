
"""
title  : 86971. 전력망을 둘로 나누기 (Level 2)
"""

from collections import deque

def solution(n, wires):

    answer = n
    
    graph = [[] for _ in range(n+1)]

    for (w1, w2) in wires:
        graph[w1].append(w2)
        graph[w2].append(w1)

    def bfs(start, end, selected):

        selected[start] = True
        selected[end] = True

        q = deque()
        q.append(start)

        count = 0
        while q:

            node = q.popleft()
            count += 1
            
            for n in graph[node]:
                if not selected[n]:
                    selected[n] = True
                    q.append(n)

        return count
    
    for (w1, w2) in wires:
        answer = min(answer, abs(bfs(w1, w2, [False] * (n+1)) - bfs(w2, w1, [False] * (n+1))))

    return answer

print(solution(9, [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]))       # 3     
print(solution(4, [[1,2],[2,3],[3,4]]))                                     # 0
print(solution(7, [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]))                   # 1