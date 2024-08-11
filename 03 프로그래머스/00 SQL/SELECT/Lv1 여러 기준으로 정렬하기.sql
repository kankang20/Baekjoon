
-- Level 1

-- 동물의 아이디, 이름, 보호 시작일
    -- 이름을 기준으로 오름차순, 이름이 같다면 보호 시작일을 기준으로 내림차순

SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC