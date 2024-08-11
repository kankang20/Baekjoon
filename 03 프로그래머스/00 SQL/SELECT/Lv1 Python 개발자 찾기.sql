
-- Level 1

-- 개발자의 ID, 이메일, 이름, 성
    -- Python 스킬을 가진 개발자
    -- ID를 기준으로 오름차순 정렬

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE "Python" in (SKILL_1, SKILL_2, SKILL_3)
ORDER BY ID ASC