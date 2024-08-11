
-- Level 1

-- 회원 수 AS USERS
    -- 나이 정보가 없는 회원

SELECT count(USER_ID) AS USERS
FROM USER_INFO
WHERE AGE IS NULL