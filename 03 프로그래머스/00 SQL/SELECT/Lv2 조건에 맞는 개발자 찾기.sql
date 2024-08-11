
-- Level 2

-- 개발자의 ID, 이메일, 이름, 성
    -- PYTHON이나 C# 스킬을 가진 개발자
    -- ID를 기준으로 오름차순 정렬
    
SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME 
FROM DEVELOPERS D
WHERE EXISTS (
    SELECT 1
    FROM SKILLCODES S
    WHERE D.SKILL_CODE & S.CODE != 0 AND S.NAME IN ('Python', 'C#') 
)
ORDER BY D.ID ASC