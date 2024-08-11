
"""
title  : 43163. 단어 변환 (Level 3)
"""

answer = float('inf')

def solution(begin, target, words):
    
    if target not in words:
        return 0
    
    visited = [False] * len(words)
    
    find(words, visited, begin, target, 0)

    return answer

def find(words, visited, begin, target, count):

    if begin == target:
        global answer
        answer = min(answer, count)
        return

    for idx in range(len(words)):
        if not visited[idx] and check(begin, words[idx]):
            visited[idx] = True
            find(words, visited, words[idx], target, count+1)
            visited[idx] = False

def check(word1, word2):
    count = 0
    for i in range(len(word1)):
        if word1[i] is not word2[i]:
            count += 1
    return True if count == 1 else False


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))       # 4
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))              # 0
