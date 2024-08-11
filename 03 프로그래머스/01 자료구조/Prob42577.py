
"""
title  : 42577. 전화번호 목록 (Level 2)
"""

def solution(phone_book):
    
    phone_book.sort()

    for idx in range(len(phone_book)-1):
        prefix = phone_book[idx]
        if prefix == phone_book[idx+1][:len(prefix)]:
            return False

    return True

print(solution(["119", "97674223", "1195524421"]))      # false
print(solution(["123","456","789"]))                    # true
print(solution(["12","123","1235","567","88"]))         # false